package ua.kolmakov.logistic.impl.model.person;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.impl.model.post.PackageImpl;

import java.awt.*;

/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */

public class Sender extends BasePerson {

    public Sender(Address address, FullName fullName) {
        super(address, fullName);
    }

    public Package createPackage() {
        return new PackageImpl();
    }
}
