package ua.kolmakov.logistic.impl.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.DeliveryTransport;
import ua.kolmakov.logistic.api.model.transport.Transit;
import ua.kolmakov.logistic.impl.service.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 * <p>
 * TransitImpl
 */
public class TransitImpl implements Transit {
    private static final List<DeliveryTransport> DELIVERY_TRANSPORTS = Storage.getInstance().getById("deliveryTransports");

    private List<PostOffice> postOffices;//transit post offices
    public TransitImpl(List<PostOffice> postOffices) {
        this.postOffices = postOffices;
    }

    @Override
    public List<PostOffice> getTransitOffices() {
        return postOffices;
    }

    @Override
    public List<DeliveryTransport> getTransitDeliveryTransports() {
        List<DeliveryTransport> result = new ArrayList<>();
        for (int i = 0; i < postOffices.size() - 1; i++) {
            for (DeliveryTransport dt : DELIVERY_TRANSPORTS) {
                if (dt.getStartPostOffice().equals(postOffices.get(i))
                        && dt.getDestinationPostOffice().equals(postOffices.get(i + 1))) {
                    result.add(dt);
                }
            }
        }
        return result;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (DeliveryTransport dt : getTransitDeliveryTransports()) {
            price += dt.getPrice();
        }
        return price;
    }

    @Override
    public double getDistance() {
        double distance = 0;
        for (DeliveryTransport dt : getTransitDeliveryTransports()) {
            distance += dt.getDistance();
        }
        return distance;
    }
}
