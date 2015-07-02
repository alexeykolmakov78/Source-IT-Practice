package ua.kolmakov.multythread_storage;

import ua.kolmakov.multythread_storage.api.Storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 * <p>
 * AutoDataStorage
 */
public class AutoDataStorage implements Storage{
    private static AutoDataStorage instance = new AutoDataStorage();

    private volatile boolean access;
    private final static Map<Object, Object> storage = new HashMap();

    public static AutoDataStorage getInstance() {
        return (instance == null) ? new AutoDataStorage() : instance;
    }

    private AutoDataStorage() {
        access = true;
    }

    public synchronized void putToStorage(Object key, Object value) {
        while (!access) {
            System.out.println("STORAGE put can't start");
            try {
                System.out.println("STORAGE put is waiting");
                wait();
            } catch (InterruptedException e) {
                System.out.println("STORAGE put interrupted");
            }
        }
        access = false;
        storage.put(key, value);
        access = true;
    }

    public synchronized <T> T getById(Object key) throws ClassCastException {
        while (!access) {
            System.out.println("STORAGE get can't start");
            try {
                System.out.println("STORAGE get is waiting");
                wait();
            } catch (InterruptedException e) {
                System.out.println("STORAGE get interrupted");
            }
        }
        access = false;
        T result = (T) storage.get(key);
//        notify();
        access = true;
        return result;
    }

//    @Override
//    public Set<Vehicle> getAllVehicles() {
//        return getById("vehicles");
//    }
//
//    @Override
//    public List<Vehicle> getVehiclesByOwnerLastName(String lastName) {
//        Set<Vehicle> vehicles = getById("vehicles");
//        return vehicles.stream()
//                .filter(v -> v.getOwner().getPassport().getLastName().equals(lastName))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart) {
//        Set<Vehicle> vehicles = getById("vehicles");
//        return vehicles.stream()
//                .filter(v -> v.getRegistrationNumber().contains(numberPart))
//                .map(Vehicle::getOwner)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices) {
//        Set<Vehicle> vehicles = getById("vehicles");
//        return vehicles.stream()
//                .filter(v -> v.getLastServiceDate().getYear() + yearsBetweenServices < new Date().getYear())//max 3 years to next service
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AutoOwner> getDrinkingAutoOwners() {
//        Set<AutoOwner> autoOwners = getById("autoOwners");
//        List<AutoOwner> drunken = new ArrayList<>();
//        for (AutoOwner a : autoOwners) {
//            drunken.addAll(
//                    a.getOffences().stream()
//                            .filter(o -> o.getType() == Offence.Type.DRUNK)
//                            .map(o -> a)
//                            .collect(Collectors.toList()));
//        }
//        return drunken;
//    }
//
//    @Override
//    public List<Vehicle> getVehiclesRTAParticipants() {
//        Set<Vehicle> vehicles = getById("vehicles");
//        return vehicles.stream()
//                .filter(v -> v.getRtaList().size() > 0)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String toString() {
//        return "AutoDataStorage{" +
//                "drivers:" + getById("drivers") +
//                "\nvehicles:" + getById("vehicles") +
//                '}';
//    }
}
