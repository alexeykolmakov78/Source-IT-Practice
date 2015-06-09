package ua.kolmakov.logistic.api.service;


import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.Transit;

import java.util.List;

/**
 * Created by Denis on 5/25/2015.
 */
public interface SenderService {
    List<PostOffice> getAllOffices();

    Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice, PostOffice destinationOffice);

    boolean sendPackage(Package parcel, Transit transit);

    PostOffice getPackageCurrentPosition(Package parcel);

    double getMilesToDestination(Package parcel);

}
