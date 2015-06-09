package ua.kolmakov.logistic.impl.model.post;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.Stamp;
import ua.kolmakov.logistic.api.model.transport.Transit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class PackageImpl implements Package {
    private static int idCounter = 0;

    private String packageId;
    private Address senderAddress;
    private FullName senderFullName;
    private Address receiverAddress;// = destinationPostAddress
    private FullName receiverFullName;
    private Type packageType;
    private int weight;
    private List<Stamp> stamps;

    private Status status;
    private Transit transit;

    public PackageImpl(Address senderAddress, FullName senderFullName, Address receiverAddress, FullName receiverFullName,
                       Type packageType, int weight) {
        this.packageId = "pac_" + idCounter;
        this.senderAddress = senderAddress;
        this.senderFullName = senderFullName;
        this.receiverAddress = receiverAddress;
        this.receiverFullName = receiverFullName;
        this.packageType = packageType;
        this.weight = weight;
        this.stamps = new ArrayList<>();

        this.status = Status.READY;
        //this.transit = null;
    }

    @Override
    public String getPackageId() {
        return packageId;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public Type getType() {
        return packageType;
    }

    @Override
    public Address getReceiverAddress() {
        return receiverAddress;
    }

    @Override
    public Address getSenderAddress() {
        return senderAddress;
    }

    @Override
    public FullName getSenderFullName() {
        return senderFullName;
    }

    @Override
    public FullName getReceiverFullName() {
        return receiverFullName;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Transit getTransit() {
        return transit;
    }

    @Override
    public void setTransit(Transit transit) {
        this.transit = transit;
    }

    @Override
    public List<Stamp> getStamps() {
        return stamps;
    }

    @Override
    public void addStamp(Stamp stamp) {
        stamps.add(stamp);
    }
}
