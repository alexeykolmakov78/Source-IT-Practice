package ua.kolmakov.multithreaded_storage.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

@XmlRootElement
public class Offence {
    private Date date;
    private Type type;

    public Offence() {
    }

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

    @XmlAttribute
    public void setDate(Date date) {
        this.date = date;
    }

    @XmlAttribute
    public void setType(Type type) {
        this.type = type;
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
