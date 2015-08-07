package ua.kolmakov.multithreaded_storage.entities;

import ua.kolmakov.logistic.api.model.person.Address;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

@XmlRootElement
public class Passport {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private String serialID;
    private Date registrationDate;
    private String registeredBy;
    private PostAddress address;

    public Passport() {
    }

    public Passport(String firstName, String lastName, String middleName, Date dateOfBirth,
                    String serialID, Date issueDate, String issuedBy, PostAddress address) {
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

    public PostAddress getAddress() {
        return address;
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


    @XmlAttribute
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlAttribute
    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    @XmlAttribute
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @XmlAttribute
    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @XmlElement
    public void setAddress(PostAddress address) {
        this.address = address;
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
