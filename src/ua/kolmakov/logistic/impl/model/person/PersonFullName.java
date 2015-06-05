package ua.kolmakov.logistic.impl.model.person;

import ua.kolmakov.logistic.api.model.person.FullName;

/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */
public class PersonFullName implements FullName {
    private String firstName;
    private String middleName;
    private String lastName;

    public PersonFullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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
