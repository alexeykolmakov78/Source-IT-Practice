package ua.kolmakov.multithreaded_storage.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

@XmlRootElement
public class Licence {
    private String serialID;
    private Category category;
    private Date registrationDate;
    private String registeredBy;
    private PostAddress address;

    public Licence() {
    }

    public Licence(String serialID, Category category, Date issueDate, String issuedBy, PostAddress address) {
        this.serialID = serialID;
        this.category = category;
        this.registrationDate = issueDate;
        this.registeredBy = issuedBy;
        this.address = address;
    }

    @XmlAttribute
    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    @XmlAttribute
    public void setCategory(Category category) {
        this.category = category;
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
    public void setAddress(PostAddress address) {
        this.address = address;
    }

    public String getSerialID() {
        return serialID;
    }

    public Category getCategory() {
        return category;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public PostAddress getAddress() {
        return address;
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
