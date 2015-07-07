package ua.kolmakov.logistic.impl.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.DeliveryTransport;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class DeliveryTransportImpl implements DeliveryTransport {
    private static int idCounter = 0;

    private Type type;
    private PostOffice startPostOffice;
    private PostOffice destinationPostOffice;
    private int distance;
    private String id;

    public DeliveryTransportImpl(Type type, PostOffice start, PostOffice destination, int distance) {
        this.type = type;
        this.startPostOffice = start;
        this.destinationPostOffice = destination;
        this.distance = distance;
        this.id = "DT_" + idCounter++;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public PostOffice getStartPostOffice() {
        return startPostOffice;
    }

    @Override
    public PostOffice getDestinationPostOffice() {
        return destinationPostOffice;
    }

    @Override
    public double getPrice() {
        return this.getType().getCostPerMile() * (distance / 1609); //1609 meters per mile
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "\nDT{" +
                " startPostOffice=" + startPostOffice.getAddress().getCity() +
                ", destinationPostOffice=" + destinationPostOffice.getAddress().getCity() +
                ", distance=" + distance +
                ", id=" + id +
                ", type=" + type +
                "}";
    }
}
