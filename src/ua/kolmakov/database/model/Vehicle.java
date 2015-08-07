package ua.kolmakov.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String registrationNumber;
    private Date productionDate;
    private Date lastServiceDate;
    private List<RTA> rtaList;
    private AutoOwner owner;

    private Vehicle() {
        rtaList = new ArrayList<>();
    }

    public static Builder newBuilder() {
        return new Vehicle().new Builder();
    }

    public int getId() {
        return id;
    }

    public AutoOwner getOwner() {
        return owner;
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

    public class Builder {
        public Builder setId(int id) {
            Vehicle.this.id = id;
            return this;
        }

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

        public Builder setOwner(AutoOwner owner) {
            Vehicle.this.owner = owner;
            return this;
        }

        public Builder setRtaList(List<RTA> rtaList) {
            Vehicle.this.rtaList = rtaList;
            return this;
        }

        public Vehicle build() {
            return Vehicle.this;
        }
    }

    @Override
    public String toString() {
        return "\n   VEHICLE{" +
                "\nbrand: " + brand +
                "\nmodel: " + model +
                "\nregistrationNumber: " + registrationNumber +
                "\nproductionDate: " + productionDate +
                "\nlastServiceDate: " + lastServiceDate +
                "\nrtaList: " + rtaList +
                "\nowner: " + ((owner == null) ? null : (owner.getPassport().getFirstName() + " " + owner.getPassport().getMiddleName() +
                " " + owner.getPassport().getLastName())) +
                "}";
    }
}
