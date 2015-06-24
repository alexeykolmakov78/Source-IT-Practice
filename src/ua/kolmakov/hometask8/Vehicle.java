package ua.kolmakov.hometask8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Vehicle {
    private String brand;
    private String model;
    private String registrationNumber;
    private Date productionDate;
    private Date lastServiceDate;
    private List<RTA> rtaList;
    private Driver owner;

    private Vehicle() {
        rtaList = new ArrayList<>();
    }

    public static Builder newBuilder() {
        return new Vehicle().new Builder();
    }

    public Driver getOwner() {
        return owner;
    }

    public void addRTA(RTA rta) {
        rtaList.add(rta);
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

        public Builder setOwner(Driver owner) {
            Vehicle.this.owner = owner;
            return this;
        }

        public Vehicle build() {
            return Vehicle.this;
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "\nbrand: " + brand+
                "\nmodel: " + model +
                "\nregistrationNumber: " + registrationNumber+
                "\nproductionDate: " + productionDate +
                "\nlastServiceDate: " + lastServiceDate +
                "\nrtaList: " + rtaList +
                "\nowner: " + owner.getPassport().getLastName() +
                "}\n";
    }
}
