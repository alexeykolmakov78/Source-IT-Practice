package ua.kolmakov.logistic.impl.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.Transit;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class TransitImpl implements Transit {

    private PostOffice[] postOffices;

    public TransitImpl(PostOffice[] postOffices) {
        this.postOffices = postOffices;
    }

    @Override
    public PostOffice[] getTransitOffices() {
        return new PostOffice[0];
    }

    @Override
    public double getPrice() {
//todo
        return 0;
    }
}
