package ua.kolmakov.multithreaded_storage.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

@XmlRootElement
public class Vehicle {

    private String brand;
    private String model;
    private String registrationNumber;
    private Date productionDate;
    private Date lastServiceDate;
    private List<RTA> rtaList;
    private String ownerLastName;

    private Vehicle() {
        rtaList = new ArrayList<>();
    }

    public static Builder newBuilder() {
        return new Vehicle().new Builder();
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public List<RTA> getRtaList() {
        return rtaList;
    }

    public void addRTA(RTA rta) {
        rtaList.add(rta);
    }

    //********************************************************



    @XmlElement
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @XmlElement
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @XmlElement
    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @XmlElementWrapper(name = "rta-list")
    @XmlElement(name = "rta")
    public void setRtaList(List<RTA> rtaList) {
        this.rtaList = rtaList;
    }


    @XmlElement
    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public class Builder {
        public Builder setBrand(String brand) {
            Vehicle.this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            Vehicle.this.model = model;
            return this;
        }

        public Builder setRegistrationNumber(String registrationNumber) {
            Vehicle.this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder setProductionDate(Date productionDate) {
            Vehicle.this.productionDate = productionDate;
            return this;
        }

        public Builder setLastServiceDate(Date lastServiceDate) {
            Vehicle.this.lastServiceDate = lastServiceDate;
            return this;
        }

        public Builder setOwnerLastName(String ownerLastName) {
            Vehicle.this.ownerLastName = ownerLastName;
            return this;
        }

        public Vehicle build() {
            return Vehicle.this;
        }
    }

    @Override
    public String toString() {
        return "\nVEHICLE{" +
                "\nbrand: " + brand +
                "\nmodel: " + model +
                "\nregistrationNumber: " + registrationNumber +
                "\nproductionDate: " + productionDate +
                "\nlastServiceDate: " + lastServiceDate +
                "\nrtaList: " + rtaList +
                "\nowner: " + ownerLastName +
                "}";
    }
}
