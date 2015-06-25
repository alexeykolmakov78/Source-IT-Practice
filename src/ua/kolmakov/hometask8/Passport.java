package ua.kolmakov.hometask8;

import ua.kolmakov.logistic.api.model.person.Address;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Passport {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private String serialID;
    private Date registrationDate;
    private String registeredBy;
    private Address address;

    public Passport(String firstName, String lastName, String middleName, Date dateOfBirth,
                    String serialID, Date issueDate, String issuedBy, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.serialID = serialID;
        this.registrationDate = issueDate;
        this.registeredBy = issuedBy;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "Name: " + firstName +
                ' ' + middleName +
                ' ' + lastName +
                ", date of birth: " + dateOfBirth +
                ", ID: " + serialID +
                ", registrationDate: " + registrationDate +
                ", registeredBy: " + registeredBy +
                ", address: " + address +
                '}';
    }
}
