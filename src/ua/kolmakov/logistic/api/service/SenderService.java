package ua.kolmakov.logistic.api.service;


import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.Transit;

/**
 * Created by Denis on 5/25/2015.
 */
public interface SenderService {
    public PostOffice[] getAllOffices();

    public Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice, PostOffice destinationOffice);

    public boolean sendPackage(Package parcel, Transit transit);

    public PostOffice getPackageCurrentPosition(String id);

    public double getMilesToDestination(String id);

}
