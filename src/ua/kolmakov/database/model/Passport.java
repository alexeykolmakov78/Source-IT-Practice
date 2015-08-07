package ua.kolmakov.database.model;


import java.sql.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Passport {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private String serialID;
    private Date registrationDate;
    private String registeredBy;


    public Passport(int id, String firstName, String lastName, String middleName, Date dateOfBirth,
                    String serialID, Date registrationDate, String registeredBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.serialID = serialID;
        this.registrationDate = registrationDate;
        this.registeredBy = registeredBy;
    }

    public int getId() {
        return id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSerialID() {
        return serialID;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getRegisteredBy() {
        return registeredBy;
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
//                ", address: " + address +
                '}';
    }
}
