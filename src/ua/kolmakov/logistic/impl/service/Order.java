package ua.kolmakov.logistic.impl.service;

import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.transport.Transit;

/**
 * Created by Kolmakov Alexey on 05.06.2015.
 */
public class Order {
    private static int idCounter = 0;

    private int id;
    private Package parcel;
    private Transit transit;
    private Status status;

    Order(Package parcel, Transit transit) {
        this.id = idCounter++;
        this.parcel = parcel;
        this.transit = transit;
        this.status = Status.READY;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        READY, SENT,  RECEIVED, FAILED
    }

}
