package ua.kolmakov.logistic.impl.model.person;

import ua.kolmakov.logistic.api.model.person.*;

/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */
public class CitizenFullName implements FullName {

    private String firstName;
    private String lastName;
    private String middleName;

    public CitizenFullName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }
}
