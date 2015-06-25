package ua.kolmakov.hometask8;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class RTA {
    private Date date;
    private int code;

    public RTA(Date date, int code) {
        this.date = date;
        this.code = code;
    }

    @Override
    public String toString() {
        return "RTA{" +
                " date: " + date +
                " code: " + code +
                '}';
    }
}
