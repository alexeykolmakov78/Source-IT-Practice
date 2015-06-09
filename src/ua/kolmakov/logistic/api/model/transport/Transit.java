package ua.kolmakov.logistic.api.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;

import java.util.List;

/**
 * Created by Denis on 5/25/2015.
 */
public interface Transit {

    public List<PostOffice> getTransitOffices();

    List<DeliveryTransport> getTransitDeliveryTransports();

    public double getPrice();
}
