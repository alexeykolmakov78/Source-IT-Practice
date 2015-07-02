package ua.kolmakov.multythread_storage.stored.objects;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Offence {
    private Date date;
    private Type type;

    public Offence(Date date, Type type) {
        this.date = date;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    // RTA is a road-transport accident
    public enum Type {
        RED_LIGHT, DRUNK, PEDESTRIAN, RTA, SPEED__LIMIT
    }

    @Override
    public String toString() {
        return "Offence{" +
                "date: " + date +
                ", type: " + type +
                '}';
    }
}
