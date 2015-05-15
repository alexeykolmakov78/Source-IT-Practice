package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 04.05.2015.
 * <p>
 * CargoCarrying
 */
public interface CargoCarrying {

    int getMaxCargo();

    Cargo getCargo();

    boolean load();

    boolean unload();
}
