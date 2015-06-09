package ua.kolmakov.logistic.impl.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.DeliveryTransport;
import ua.kolmakov.logistic.api.model.transport.Transit;
import ua.kolmakov.logistic.impl.service.Storage;

import java.util.List;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class TransitImpl implements Transit {

    private List<PostOffice> postOffices;//transit post offices
    private List<DeliveryTransport> deliveryTransports;//transit delivery transports

    public TransitImpl(List<PostOffice> postOffices) {
        this.postOffices = postOffices;
        // здесь deliveryTransports нужно задавать в конструкторе, а postOffices вычислять в методе getTransitOffices()
        deliveryTransports = Storage.getInstance().getById("deliveryTransports");
    }

    @Override
    public List<PostOffice> getTransitOffices() {
        return postOffices;
    }

    @Override
    public List<DeliveryTransport> getTransitDeliveryTransports() {
        return deliveryTransports;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (DeliveryTransport dt : deliveryTransports) {
            price += dt.getPrice();
        }
        return price;
    }
}
