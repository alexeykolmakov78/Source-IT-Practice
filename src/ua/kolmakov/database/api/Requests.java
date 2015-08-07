package ua.kolmakov.database.api;

import ua.kolmakov.database.model.AutoOwner;
import ua.kolmakov.database.model.Vehicle;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by Kolmakov Alexey on 24.06.2015.
 */
public interface Requests {

    List<Vehicle> getAllVehicles() throws SQLException;

    List<Vehicle> getVehiclesByOwnerLastName(String lastName) throws SQLException;

    List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart) throws SQLException;

    List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices) throws SQLException;

    List<AutoOwner> getDrinkingAutoOwners() throws SQLException;

    List<Vehicle> getVehiclesRTAParticipants() throws SQLException;
}
