package ua.kolmakov.hometask8.api;

import ua.kolmakov.hometask8.AutoOwner;
import ua.kolmakov.hometask8.Vehicle;

import java.util.List;
import java.util.Set;

/**
 * Created by Kolmakov Alexey on 24.06.2015.
 */
public interface AutoDataRequests {

    Set<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesByOwnerLastName(String lastName);

    List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart);

    List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices);

    List<AutoOwner> getDrinkingAutoOwners();

    List<Vehicle> getVehiclesRTAParticipants();
}
