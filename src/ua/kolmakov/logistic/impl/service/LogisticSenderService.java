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
import ua.kolmakov.logistic.impl.model.transport.DeliveryTransportImpl;
import ua.kolmakov.logistic.impl.model.transport.TransitImpl;

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
    private static final int NUMBER_OF_DELIVERY_TRANSPORTS = 30;

    private Storage storage;
    private Initializer initializer;

    public LogisticSenderService() {
        storage = Storage.getInstance();
        initializer = new Initializer();
        initializer.initService();
    }

    @Override
    public List<PostOffice> getAllOffices() {
        return storage.getById("postOffices");
    }

    @Override
    public Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice, PostOffice destinationOffice) {
        Transit[] result = new Transit[2];
        Dijkstra dijkstra = Dijkstra.getDijkstra();
        dijkstra.search(senderOffice, Dijkstra.SearchParam.COST);
        result[0] = new TransitImpl(dijkstra.getTransit(destinationOffice));
        dijkstra.search(senderOffice, Dijkstra.SearchParam.DISTANCE);
        result[1] = new TransitImpl(dijkstra.getTransit(destinationOffice));
        return result;
    }

    /**
     * Send the parcel from the start post office of the transit to the destination one
     * through all transit post offices.
     *
     * @param parcel  the sent package
     * @param transit transit from the start post office to the destination post office
     * @return result of the operation:
     * true if the parcel was received at the destination post office,
     * false otherwise
     */
    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        parcel.setTransit(transit);
        List<PostOffice> transitOffices = transit.getTransitOffices();
        PostOffice fromOffice;
        PostOffice toOffice;
        for (int i = 0; i < transitOffices.size() - 1 && parcel.getStatus() != Package.Status.FAILED; i++) {
            fromOffice = transitOffices.get(i);
            toOffice = transitOffices.get(i + 1);
            //send package to the next post office in the transit
            //if success set order status SENT
            if (fromOffice.sendPackage(parcel)) {
                parcel.setStatus(Package.Status.SENT);
                //receive package
                //if failed set status FAILED
                //if toOffice is destination set status RECEIVED
                if (toOffice.receivePackage(parcel) && parcel.getReceiverAddress().equals(toOffice.getAddress())) {
                    parcel.addStamp(toOffice.getStamp());
                    parcel.setStatus(Package.Status.RECEIVED);
                } else {
                    continue;
                }
            } else parcel.setStatus(Package.Status.FAILED);
        }
        return parcel.getStatus() == Package.Status.RECEIVED;
    }

    @Override
    public PostOffice getPackageCurrentPosition(Package parcel) {
        Address address;
        if (parcel.getStamps().size() == 0) {
            address = parcel.getSenderAddress();
        } else {
            int index = parcel.getStamps().size() - 1;
            Stamp lastStamp = parcel.getStamps().get(index);
            address = lastStamp.getPostOfficeAddress();
        }
        return storage.getPostOfficeByAddress(address);
    }

    @Override
    public double getMilesToDestination(Package parcel) {
        int milesToDest = 0;
        PostOffice currentPO = getPackageCurrentPosition(parcel);
        DeliveryTransport currentDT = findCurrentDT(currentPO, parcel);
        List<DeliveryTransport> transitDT = parcel.getTransit().getTransitDeliveryTransports();
        int index = transitDT.indexOf(currentDT);
        for (int i = index; i < transitDT.size(); i++) {//in case of currentDT == null index = -1
            if (index >= 0){
                milesToDest += transitDT.get(i).getDistance();
            }
        }
        return milesToDest;
    }

    private DeliveryTransport findCurrentDT(PostOffice currentPO, Package parcel) {
        Transit transit = parcel.getTransit();
        if (transit == null) {
            throw new IllegalArgumentException("Empty Transit !!!!!");
        } else {
            List<DeliveryTransport> transitDT = transit.getTransitDeliveryTransports();
            for (DeliveryTransport each : transitDT) {
                if (each.getStartPostOffice().equals(currentPO))
                    return each;
            }
        }
        return null;
    }

    private static int calculateDistance(Point from, Point to) {
        return (int) Math.round(from.distance(to));
    }

    private final class Initializer {

        private Random rnd = new Random();

        private void initService() {
            generatePostOffices();
            generateDeliveryTransports();
        }

        private void generatePostOffices() {
            List<PostOffice> postOffices = new ArrayList<>();

            Address address;
            Package.Type[] accessiblePackageTypes;
            int maxPackageWeight;
            Point location;

            address = new PostAddress(12345, "Ukraine", "Kharkov", "Ivanova");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxPackageWeight = 100;
            location = new Point(12345, 10102);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(63524, "Ukraine", "Kiev", "Shevchenco");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_30, Package.Type.T_25};
            maxPackageWeight = 100;
            location = new Point(24513, 20007);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(44466, "Ukraine", "Donetsk", "Artema");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_27,};
            maxPackageWeight = 30;
            location = new Point(22855, 35784);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(56478, "Russia", "Moscow", "Tverskaja");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_CP, Package.Type.T_25, Package.Type.T_30, Package.Type.T_27};
            maxPackageWeight = 50;
            location = new Point(45896, 90444);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(50987, "Russia", "StPeterburg", "Nevcki");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxPackageWeight = 100;
            location = new Point(62541, 65586);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(45456, "Russia", "Novgorod", "Lenina");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_30, Package.Type.T_25};
            maxPackageWeight = 100;
            location = new Point(11945, 24059);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(95864, "England", "London", "Times Square");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_27};
            maxPackageWeight = 50;
            location = new Point(18755, 98640);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(25896, "UAE", "Dubai", "Burj Halifa");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_27,};
            maxPackageWeight = 30;
            location = new Point(88545, 62418);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(65489, "USA", "New York", "34-ave");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_10, Package.Type.T_25, Package.Type.T_30};
            maxPackageWeight = 150;
            location = new Point(55284, 12563);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            address = new PostAddress(15396, "France", "Paris", "Mulen Rouge");
            accessiblePackageTypes = new Package.Type[]{Package.Type.T_25, Package.Type.T_27,};
            maxPackageWeight = 300;
            location = new Point(44455, 67788);
            postOffices.add(new PostOfficeImpl(accessiblePackageTypes, address, maxPackageWeight, location));

            storage.putToStorage("postOffices", postOffices);
        }

        private void generateDeliveryTransports() {
            DeliveryTransport.Type transportType;
            int distance;
            PostOffice from;
            PostOffice to;
            List<String> startPostOfficeCities = new ArrayList<>(Arrays.asList(new String[]{
                    "Kharkov", "Kharkov", "Kiev", "Kharkov", "Kiev",
                    "Kiev", "Kiev", "Moscow", "Moscow", "Moscow",
                    "Moscow", "StPeterburg", "London", "Paris", "London"}));
            List<String> destPostOfficeCities = new ArrayList<>(Arrays.asList(new String[]{
                    "Donetsk", "Kiev", "Donetsk", "Moscow", "Paris",
                    "Moscow", "StPeterburg", "StPeterburg", "Novgorod", "Dubai",
                    "London", "Novgorod", "Paris", "New York", "Dubai"}));

            List<DeliveryTransport> deliveryTransports = new ArrayList<>();

            for (int i = 0; i < NUMBER_OF_DELIVERY_TRANSPORTS / 2; i++) {
                from = getPostOfficeByCountry(startPostOfficeCities.get(i));
                to = getPostOfficeByCountry(destPostOfficeCities.get(i));
                transportType = randomTransportType();
                distance = calculateDistance(from.getGeolocation(), to.getGeolocation());
                deliveryTransports.add(new DeliveryTransportImpl(transportType, from, to, distance));
                // add the road back
                deliveryTransports.add(new DeliveryTransportImpl(transportType, to, from, distance));
            }
            storage.putToStorage("deliveryTransports", deliveryTransports);
        }

        private PostOffice getPostOfficeByCountry(String s) {
            List<PostOffice> postOffices = storage.getById("postOffices");
            for (PostOffice po : postOffices) {
                if (po.getAddress().getCity().equals(s)) {
                    return po;
                }
            }
            return null;
        }

        // mock version without path searching
        private void generateDeliveryTransports1() {
            DeliveryTransport.Type transportType;
            int distance;
            PostOffice from;
            PostOffice to;

            List<DeliveryTransport> deliveryTransports = new ArrayList<>();
            List<PostOffice> postOffices = storage.getById("postOffices");

            for (int i = 0; i < NUMBER_OF_OFFICES - 1; i++) {
                from = postOffices.get(i);
                to = postOffices.get(i + 1);
                transportType = randomTransportType();
                distance = calculateDistance(from.getGeolocation(), to.getGeolocation());
                deliveryTransports.add(new DeliveryTransportImpl(transportType, from, to, distance));
            }
            storage.putToStorage("deliveryTransports", deliveryTransports);
        }

        private DeliveryTransport.Type randomTransportType() {
            int index = rnd.nextInt(DeliveryTransport.Type.values().length);
            return DeliveryTransport.Type.values()[index];
        }

    }

}



