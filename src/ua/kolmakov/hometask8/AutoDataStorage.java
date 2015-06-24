package ua.kolmakov.hometask8;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class AutoDataStorage {
    private static AutoDataStorage instance;

    private Collection<Driver> drivers;
    private Collection<Vehicle> vehicles;

    private final static Map<Object, Object> storage = new HashMap();

    private AutoDataStorage() {
        this.drivers = new HashSet<>();
        this.vehicles = new HashSet<>();
    }

    public static AutoDataStorage getInstance() {
        return (instance == null) ? new AutoDataStorage() : instance;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }




    public void putToStorage(Object key, Object value) {
        storage.put(key, value);
    }

    public <T> T getById(Object key) throws ClassCastException{
        return (T)storage.get(key);
    }

    @Override
    public String toString() {
        return "AutoDataStorage{" +
                "drivers:" + getById("drivers")

                +
                ", vehicles:" + getById("vehicles") +
                '}';
    }
}
