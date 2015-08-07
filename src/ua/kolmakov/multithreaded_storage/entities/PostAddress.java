package ua.kolmakov.multithreaded_storage.entities;

import ua.kolmakov.logistic.api.model.person.Address;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kolmakov Alexey on 27.05.2015.
 */

@XmlRootElement(name = "address")
public class PostAddress implements Address {

    private String street;
    private String city;
    private String country;
    private int code;

    public PostAddress() {
    }

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

    @XmlAttribute(name = "street")
    public void setStreet(String street) {
        this.street = street;
    }

    @XmlAttribute(name = "city")
    public void setCity(String city) {
        this.city = city;
    }

    @XmlAttribute(name = "country")
    public void setCountry(String country) {
        this.country = country;
    }

    @XmlAttribute(name = "code")
    public void setCode(int code) {
        this.code = code;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostAddress that = (PostAddress) o;

        if (code != that.code) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return !(country != null ? !country.equals(that.country) : that.country != null);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + code;
        return result;
    }
}
