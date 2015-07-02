package ua.kolmakov.multythread_storage.api;

import ua.kolmakov.multythread_storage.stored.objects.AutoOwner;
import ua.kolmakov.multythread_storage.stored.objects.Vehicle;

import java.util.List;
import java.util.Set;

/**
 * Created by Kolmakov Alexey on 24.06.2015.
 */
public interface Requests {

    Set<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesByOwnerLastName(String lastName);

    List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart);

    List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices);

    List<AutoOwner> getDrinkingAutoOwners();

    List<Vehicle> getVehiclesRTAParticipants();
}
