package ua.kolmakov.logistic.impl.model.post;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.post.Stamp;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class StampImpl implements Stamp {

    private Address address;
    private Date date;

    public StampImpl(Address address) {
        this.address = address;
        this.date = new Date();
    }

    @Override
    public Address getPostOfficeAddress() {
        return address;
    }

    @Override
    public Date getStampDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Stamp{" +
                "addr=" + address +
                ", date=" + date +
                "}\n";
    }
}
