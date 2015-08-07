package ua.kolmakov.multithreaded_storage.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

@XmlRootElement
public class RTA {
    private Date date;
    private int code;

    public RTA() {
    }

    public RTA(Date date, int code) {
        this.date = date;
        this.code = code;
    }

    @XmlAttribute
    public void setDate(Date date) {
        this.date = date;
    }

    @XmlAttribute
    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "RTA{" +
                " date: " + date +
                " code: " + code +
                '}';
    }
}
