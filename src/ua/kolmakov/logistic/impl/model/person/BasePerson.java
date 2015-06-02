package ua.kolmakov.logistic.impl.model.person;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.api.model.person.Person;

/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */
public class BasePerson implements Person {
    protected Address address;
    protected FullName fullName;

    public BasePerson(Address address, FullName fullName) {
        this.address = address;
        this.fullName = fullName;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public FullName getFullName() {
        return fullName;
    }
}