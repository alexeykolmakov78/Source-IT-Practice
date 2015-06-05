package ua.kolmakov.logistic.api.model.person;

import ua.kolmakov.logistic.api.model.post.Package;

/**
 * Created by Denis on 5/25/2015.
 */
public interface Person {
    Address getAddress();

    FullName getFullName();

    Package createPackage(Address receiverAddress, FullName receiverFullName, Package.Type type, int packageWeight);

}

