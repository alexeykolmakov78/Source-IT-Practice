package ua.kolmakov.logistic.impl.model.person;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.impl.model.post.PackageImpl;


/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */

public class Sender extends BasePerson {

    public Sender(Address address, FullName fullName) {
        super(address, fullName);
    }

    public Package createPackage(Address receiverAddress, FullName receiverFullName, Package.Type type, int packageWeight) {
        Address senderAddress = this.getAddress();
        FullName senderName = this.getFullName();
        Address destinationAddress = receiverAddress;
        FullName receiverName = receiverFullName;
        Package.Type packageType = type;
        int weight = packageWeight;
        return new PackageImpl(senderAddress,senderName,destinationAddress,receiverName,packageType,packageWeight);
    }
}
