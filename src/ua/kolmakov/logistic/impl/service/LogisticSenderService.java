package ua.kolmakov.logistic.impl.service;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.post.Stamp;
import ua.kolmakov.logistic.api.model.transport.DeliveryTransport;
import ua.kolmakov.logistic.api.model.transport.Transit;
import ua.kolmakov.logistic.api.service.SenderService;
import ua.kolmakov.logistic.impl.model.person.PostAddress;
import ua.kolmakov.logistic.impl.model.post.PostOfficeImpl;
import ua.kolmakov.logistic.impl.model.post.StampImpl;
import ua.kolmakov.logistic.impl.model.transport.DeliveryTransportImpl;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class LogisticSenderService implements SenderService {
    private static final int NUMBER_OF_OFFICES = 10;
    private static final int NUMBER_OF_DELIVERY_TRANSPORTS = NUMBER_OF_OFFICES * 2;
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

        List<DeliveryTransport> transit;

        List<List<DeliveryTransport>> transits = new ArrayList<>();

        List<DeliveryTransport> startDeliveryTransports = new ArrayList<>();

        for (DeliveryTransport each : deliveryTransports) {
            if (each.getStartPostOffice() == senderOffice) {
                startDeliveryTransports.add(each);
            }
        }

        for (DeliveryTransport each : startDeliveryTransports) {
            transit = createTransit(each, destinationOffice);
            if(transit!=null){
                // здесь нужно переходить от DeliveryTransport к PostOffice
                transits.add(transit);
            }
        }


        return (Transit[]) transits.toArray();
    }

    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        return false;
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        return null;
    }

    @Override
    public double getMilesToDestination(String id) {
        return 0;
    }

    private List<DeliveryTransport> createTransit(DeliveryTransport startDeliveryTransport, PostOffice destinationOffice) {
//        List<DeliveryTransport>

//        for(DeliveryTransport each:)


        return null;
    }



    private final class Initializer {

        private Random rnd = new Random();

        private void initService() {
            postOffices = new PostOffice[NUMBER_OF_OFFICES];
            deliveryTransports = new DeliveryTransportImpl[NUMBER_OF_DELIVERY_TRANSPORTS];
            generatePostOffices();
            generateDeliveryTransports();
        }

        private void generatePostOffices() {
            Address address;
            Stamp stamp;
            Package.Type[] accessiblePackageTypes;
            int maxWeight;
            int code;
            Point location;

            address = new PostAddress(12345, "Ukraine", "Kharkov", "Ivanova");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxWeight = 100;
            code = address.getCode();
            location = new Point(12345, 10102);
            postOffices[0] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(63524, "Ukraine", "Kiev", "Shevchenco");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_30, Package.Type.T_25};
            maxWeight = 100;
            code = address.getCode();
            location = new Point(24513, 20007);
            postOffices[1] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(56478, "Russia", "Moscow", "Tverskaja");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_CP, Package.Type.T_25, Package.Type.T_30, Package.Type.T_27};
            maxWeight = 50;
            code = address.getCode();
            location = new Point(45896, 90444);
            postOffices[2] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(44466, "Ukraine", "Donetsk", "Artema");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_27,};
            maxWeight = 30;
            code = address.getCode();
            location = new Point(22855, 35784);
            postOffices[3] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(50987, "Russia", "StPeterburg", "Nevcki");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxWeight = 100;
            code = address.getCode();
            location = new Point(62541, 65586);
            postOffices[4] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(45456, "Russia", "Novgorod", "Lenina");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_30, Package.Type.T_25};
            maxWeight = 100;
            code = address.getCode();
            location = new Point(11945, 24059);
            postOffices[5] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(95864, "England", "London", "Times square");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxWeight = 50;
            code = address.getCode();
            location = new Point(18755, 98640);
            postOffices[6] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(25896, "UAE", "Dubai", "Burj Halifa");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_27,};
            maxWeight = 30;
            code = address.getCode();
            location = new Point(88545, 62418);
            postOffices[7] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(65489, "USA", "New York", "34-ave");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_30};
            maxWeight = 150;
            code = address.getCode();
            location = new Point(55284, 12563);
            postOffices[8] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);

            address = new PostAddress(15396, "France", "Paris", "Mulen Rouge");
            stamp = new StampImpl(address);
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_25, Package.Type.T_27,};
            maxWeight = 300;
            code = address.getCode();
            location = new Point(44455, 67788);
            postOffices[9] = new PostOfficeImpl(accessiblePackageTypes, stamp, address, maxWeight, code, location);
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
            for (DeliveryTransport item : deliveryTransports) {
                System.out.println(item);
            }


            System.out.println(Arrays.toString(deliveryTransports));
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



