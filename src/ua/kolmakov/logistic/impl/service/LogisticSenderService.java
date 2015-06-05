package ua.kolmakov.logistic.impl.service;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.DeliveryTransport;
import ua.kolmakov.logistic.api.model.transport.Transit;
import ua.kolmakov.logistic.api.service.SenderService;
import ua.kolmakov.logistic.impl.model.person.PostAddress;
import ua.kolmakov.logistic.impl.model.post.PostOfficeImpl;
import ua.kolmakov.logistic.impl.model.transport.DeliveryTransportImpl;
import ua.kolmakov.logistic.impl.model.transport.TransitImpl;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class LogisticSenderService implements SenderService {
    private static final int NUMBER_OF_OFFICES = 10;
    private static final int NUMBER_OF_DELIVERY_TRANSPORTS = NUMBER_OF_OFFICES * 2;

    private boolean visited[] = new boolean[NUMBER_OF_OFFICES];
    private PostOffice[] transitOffices;
    private Initializer initializer;

    private PostOffice[] postOffices;
    private DeliveryTransport[] deliveryTransports;

    private Storage storage;

    public LogisticSenderService() {
        storage = Storage.getInstance();
        initializer = new Initializer();
        initializer.initService();
    }

    @Override
    public PostOffice[] getAllOffices() {
        return postOffices;
    }

    @Override
    public Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice, PostOffice destinationOffice) {

        Transit[] result = new Transit[2];
        result[0] = cheapestTransit(senderOffice, destinationOffice);
        result[1] = shortestTransit(senderOffice, destinationOffice);
        return result;
    }

    private Transit shortestTransit(PostOffice senderOffice, PostOffice destinationOffice) {
        return null;
    }

    private Transit cheapestTransit(PostOffice senderOffice, PostOffice destinationOffice) {

        transitOffices = startPoint(senderOffice);

        return new TransitImpl(transitOffices);
    }

    private void dfs(int index) {// обход в глубину
        visited[index] = true;
        transitOffices[0] = postOffices[index];
        for (int i = 0; i < NUMBER_OF_OFFICES; i++) {
            for (int j = 0; j < NUMBER_OF_DELIVERY_TRANSPORTS; j++) {
                if (!visited[i]) {
                    if (postOffices[i] != deliveryTransports[j].getStartPostOffice()) {
                        dfs(i);
                    } else if (postOffices[i] != deliveryTransports[j].getDestinationPostOffice()) {
                        transitOffices[i] = postOffices[i];
                        dfs(i);
                    } else {
                        transitOffices[i] = postOffices[i];
                    }
                }
            }
        }
    }

    /**
     * This method set senderOffice at the first position of the array of all post offices.
     *
     * @param senderOffice the post office of the sender.
     * @return an array of the post offices where the sender office is at the first position.
     */
    private PostOffice[] startPoint(PostOffice senderOffice) {
        PostOffice[] result = new PostOffice[NUMBER_OF_OFFICES];
        System.arraycopy(postOffices, 0, result, 0, NUMBER_OF_OFFICES);
        int startIndex = 0;
        for (int i = 1; i < NUMBER_OF_OFFICES; i++) {
            if (result[i].equals(senderOffice)) {
                startIndex = i;
                break;
            }
        }
        if (startIndex != 0) {
            PostOffice tmp = result[startIndex];
            result[startIndex] = result[0];
            result[0] = tmp;
        }
        return result;
    }

    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        Order order = new Order(parcel, transit);

        PostOffice[] transitOffices = transit.getTransitOffices();
        PostOffice fromOffice;
        PostOffice toOffice;
        for (int i = 0; i < transitOffices.length - 1 && order.getStatus() != Order.Status.FAILED; i++) {
            fromOffice = transitOffices[i];
            toOffice = transitOffices[i + 1];
            //send package to the next post office in the transit
            //if success set order status SENT
            if (fromOffice.sendPackage(parcel)) {
                order.setStatus(Order.Status.SENT);
                //receive package
                //if failed set status FAILED
                //if toOffice is destination set status RECEIVED
                if (toOffice.receivePackage(parcel) && toOffice.getAddress() == parcel.getReceiverAddress()) {
                    order.setStatus(Order.Status.RECEIVED);
                } else order.setStatus(Order.Status.FAILED);

            } else order.setStatus(Order.Status.FAILED);
        }

        return Order.Status.RECEIVED == order.getStatus();
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        return null;
    }

    @Override
    public double getMilesToDestination(String id) {
        return 0;
    }


    private final class Initializer {

        private Random rnd = new Random();

        private void initService() {
            postOffices = new PostOffice[NUMBER_OF_OFFICES];
            deliveryTransports = new DeliveryTransportImpl[NUMBER_OF_DELIVERY_TRANSPORTS];
            generatePostOffices();
            generateDeliveryTransports();
            System.out.println(storage.toString());
        }

        private void generatePostOffices() {
            Address address;
            Package.Type[] accessiblePackageTypes;
            int maxWeight;
            Point location;

            address = new PostAddress(12345, "Ukraine", "Kharkov", "Ivanova");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxWeight = 100;
            location = new Point(12345, 10102);
            postOffices[0] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(63524, "Ukraine", "Kiev", "Shevchenco");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_30, Package.Type.T_25};
            maxWeight = 100;
            location = new Point(24513, 20007);
            postOffices[1] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(56478, "Russia", "Moscow", "Tverskaja");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_CP, Package.Type.T_25, Package.Type.T_30, Package.Type.T_27};
            maxWeight = 50;
            location = new Point(45896, 90444);
            postOffices[2] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(44466, "Ukraine", "Donetsk", "Artema");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_27,};
            maxWeight = 30;
            location = new Point(22855, 35784);
            postOffices[3] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(50987, "Russia", "StPeterburg", "Nevcki");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxWeight = 100;
            location = new Point(62541, 65586);
            postOffices[4] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(45456, "Russia", "Novgorod", "Lenina");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_30, Package.Type.T_25};
            maxWeight = 100;
            location = new Point(11945, 24059);
            postOffices[5] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(95864, "England", "London", "Times square");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxWeight = 50;
            location = new Point(18755, 98640);
            postOffices[6] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(25896, "UAE", "Dubai", "Burj Halifa");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_27,};
            maxWeight = 30;
            location = new Point(88545, 62418);
            postOffices[7] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(65489, "USA", "New York", "34-ave");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_30};
            maxWeight = 150;
            location = new Point(55284, 12563);
            postOffices[8] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            address = new PostAddress(15396, "France", "Paris", "Mulen Rouge");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_25, Package.Type.T_27,};
            maxWeight = 300;
            location = new Point(44455, 67788);
            postOffices[9] = new PostOfficeImpl(accessiblePackageTypes, address, maxWeight, location);

            for(PostOffice each: postOffices ){
                storage.putToStorage(each.getId(), each);
            }

        }

        private void generateDeliveryTransports() {
            DeliveryTransport.Type transportType;
            int distance;
            PostOffice nextPostOffice;
            PostOffice randomPostOffice;

            for (int i = 0; i < NUMBER_OF_OFFICES; i++) {
                transportType = randomTransportType();
                nextPostOffice = postOffices[i];
                randomPostOffice = randomPostOffice(nextPostOffice);
                distance = randomDistance();

                deliveryTransports[i] = new DeliveryTransportImpl(transportType, nextPostOffice, randomPostOffice, distance);
                deliveryTransports[i + 10] = new DeliveryTransportImpl(transportType, randomPostOffice, nextPostOffice, distance);
            }

            for (DeliveryTransport each : deliveryTransports) {
                storage.putToStorage(each.getId(), each);
            }

        }

        private DeliveryTransport.Type randomTransportType() {
            int index = rnd.nextInt(DeliveryTransport.Type.values().length);
            return DeliveryTransport.Type.values()[index];
        }

        private PostOffice randomPostOffice(PostOffice nextPostOffice) {
            PostOffice result;
            int index;
            result = nextPostOffice;
            while (result == nextPostOffice) {
                index = rnd.nextInt(NUMBER_OF_OFFICES);
                result = postOffices[index];
            }
            return result;
        }

        private int randomDistance() {
            return rnd.nextInt(1000) + 300;
        }

    }

}



