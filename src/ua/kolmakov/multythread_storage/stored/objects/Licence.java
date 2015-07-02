package ua.kolmakov.multythread_storage.stored.objects;

import ua.kolmakov.logistic.api.model.person.Address;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Licence {
    private String serialID;
    private Category category;
    private Date registrationDate;
    private String registeredBy;
    private Address address;

    public Licence(String serialID, Category category, Date issueDate, String issuedBy, Address address) {
        this.serialID = serialID;
        this.category = category;
        this.registrationDate = issueDate;
        this.registeredBy = issuedBy;
        this.address = address;
    }

    public enum Category{
        A,B,C,D
    }

    @Override
    public String toString() {
        return "Licence{" +
                "serialID='" + serialID + '\'' +
                ", category=" + category +
                ", registrationDate=" + registrationDate +
                ", registeredBy='" + registeredBy + '\'' +
                ", address=" + address +
                '}';
    }
}
