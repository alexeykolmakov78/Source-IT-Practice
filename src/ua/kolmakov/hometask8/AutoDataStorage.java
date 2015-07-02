package ua.kolmakov.hometask8;

import ua.kolmakov.hometask8.api.AutoDataRequests;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 * <p>
 * AutoDataStorage
 */
public class AutoDataStorage implements AutoDataRequests {
    private static AutoDataStorage instance = new AutoDataStorage();
    private final static Map<Object, Object> storage = new HashMap();

    private AutoDataStorage() {
    }

    public static AutoDataStorage getInstance() {
        return (instance == null) ? new AutoDataStorage() : instance;
    }

    public void putToStorage(Object key, Object value) {
        storage.put(key, value);
    }

    public <T> T getById(Object key) throws ClassCastException {
        return (T) storage.get(key);
    }

    @Override
    public Set<Vehicle> getAllVehicles() {
        return getById("vehicles");
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerLastName(String lastName) {
        Set<Vehicle> vehicles = getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getOwner().getPassport().getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart) {
        Set<Vehicle> vehicles = getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getRegistrationNumber().contains(numberPart))
                .map(Vehicle::getOwner)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices) {
        Set<Vehicle> vehicles = getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getLastServiceDate().getYear() + yearsBetweenServices < new Date().getYear())//max 3 years to next service
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoOwner> getDrinkingAutoOwners() {
        Set<AutoOwner> autoOwners = getById("autoOwners");
        List<AutoOwner> drunken = new ArrayList<>();
        for (AutoOwner a : autoOwners) {
            drunken.addAll(
                    a.getOffences().stream()
                            .filter(o -> o.getType() == Offence.Type.DRUNK)
                            .map(o -> a)
                            .collect(Collectors.toList()));
        }
        return drunken;
    }

    @Override
    public List<Vehicle> getVehiclesRTAParticipants() {
        Set<Vehicle> vehicles = getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getRtaList().size() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "AutoDataStorage{" +
                "drivers:" + getById("drivers") +
                "\nvehicles:" + getById("vehicles") +
                '}';
    }
}
