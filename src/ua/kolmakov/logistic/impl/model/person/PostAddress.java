package ua.kolmakov.logistic.impl.model.person;

import ua.kolmakov.logistic.api.model.person.Address;

/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */
public class PostAddress implements Address {

    private String street;
    private String city;
    private String country;
    private int code;

    public PostAddress(int code, String country, String city, String street) {
        this.code = code;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", code=" + code +
                '}';
    }
}
