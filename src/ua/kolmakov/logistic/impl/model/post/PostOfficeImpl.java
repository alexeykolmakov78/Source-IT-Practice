package ua.kolmakov.logistic.impl.model.post;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.post.Stamp;
import ua.kolmakov.logistic.impl.service.Storage;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class PostOfficeImpl implements PostOffice {

    private static Storage storage = Storage.getInstance();
    private static int idCounter = 0;

    private final String id;
    private final Address address;
    private final Package.Type[] acceptablePackageTypes;
    private final int maxWeight;
    private final Point location;

    public PostOfficeImpl(Package.Type[] acceptablePackageTypes,  Address address, int maxWeight,
                         Point location) {
        this.id = "PO_" + idCounter++;
        this.acceptablePackageTypes = acceptablePackageTypes;
        this.address = address;
        this.maxWeight = maxWeight;
        this.location = location;
    }

    @Override
    public Stamp getStamp() {
        return new StampImpl(this.address);
    }
    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public Package.Type[] getAcceptableTypes() {
        return acceptablePackageTypes;
    }

    @Override
    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public boolean sendPackage(Package parcel) {
        if (forceMajeure()) {
            return false;
        } else {
            parcel.addStamp(this.getStamp());
            return true;
        }
    }

    private boolean forceMajeure() {
        Random rnd = new Random();
        return (rnd.nextInt(13)==13);
    }

    @Override
    public boolean receivePackage(Package parcel) {
        if (forceMajeure()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getCode() {
        return address.getCode();
    }

    @Override
    public Point getGeolocation() {
        return location;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "PO{" +
                "address=" + address +
                ",maxWeight=" + maxWeight +
                ",location=" + location.getX() + "," + location.getY() +
                ",acceptablePackageTypes=" + Arrays.toString(acceptablePackageTypes) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostOfficeImpl that = (PostOfficeImpl) o;

        if (!id.equals(that.id)) return false;
        if (!address.equals(that.address)) return false;
        return location.equals(that.location);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
