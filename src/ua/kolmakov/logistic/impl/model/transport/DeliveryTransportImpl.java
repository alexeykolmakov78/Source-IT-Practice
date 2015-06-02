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
    private int id;

    public DeliveryTransportImpl( Type type, PostOffice start, PostOffice destination, int distance) {
        this.type = type;
        this.startPostOffice = start;
        this.destinationPostOffice = destination;
        this.distance = distance;
        this.id = idCounter++;
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
    public String toString() {
        return "DT{" +
                " startPostOffice=" + startPostOffice.getCode() +
                ", destinationPostOffice=" + destinationPostOffice.getCode() +
                ", distance=" + distance +
                ", id=" + id +
                ", type=" + type +
                "}";
    }
}
