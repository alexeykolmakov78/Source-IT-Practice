package ua.kolmakov.multithreaded_storage.api;

import ua.kolmakov.multithreaded_storage.entities.AutoOwner;
import ua.kolmakov.multithreaded_storage.entities.Vehicle;

import java.util.List;
import java.util.Set;

/**
 * Created by Kolmakov Alexey on 24.06.2015.
 */
public interface Requests {

    List<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesByOwnerLastName(String lastName);

    List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart);

    List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices);

    List<AutoOwner> getDrinkingAutoOwners();

    List<Vehicle> getVehiclesRTAParticipants();
}
