package ua.kolmakov.logistic.impl.model.post;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.post.Stamp;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class PostOfficeImpl implements PostOffice {
    private final Stamp stamp;
    private final Address address;
    private final Package.Type[] acceptablePackageTypes;
    private final int maxWeight;
    private final int code;
    private final Point location;

    public PostOfficeImpl(Package.Type[] acceptablePackageTypes, Stamp stamp, Address address, int maxWeight, int code, Point location) {
        this.acceptablePackageTypes = acceptablePackageTypes;
        this.stamp = stamp;
        this.address = address;
        this.maxWeight = maxWeight;
        this.code = code;
        this.location = location;
    }

    @Override
    public Stamp getStamp() {
        return null;
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
        return false;
    }

    @Override
    public boolean receivePackage(Package parcel) {
        return false;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public Point getGeolocation() {
        return location;
    }

    @Override
    public String toString() {
        return "PO{" +
                "address=" + address +
                ",maxWeight=" + maxWeight +
                ",code=" + code +
                ",location=" + location.getX() + "," + location.getY() +
                ",acceptablePackageTypes=" + Arrays.toString(acceptablePackageTypes) +
                "}\n";
    }
}
