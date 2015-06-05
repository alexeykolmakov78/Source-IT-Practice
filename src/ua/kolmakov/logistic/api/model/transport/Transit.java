package ua.kolmakov.logistic.api.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;

/**
 * Created by Denis on 5/25/2015.
 */
public interface Transit {


    public PostOffice[] getTransitOffices();

    public double getPrice();
}
