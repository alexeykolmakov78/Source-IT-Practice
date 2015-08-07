package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 03.05.2015.
 * <p>
 * Abstract Car.
 */
public abstract class AbstractVehicle implements Vehicle {

    protected int weight;
    protected int maxSpeedKm;
    protected Dimension dimension;
    protected String brand;

    public AbstractVehicle() {
    }

    public AbstractVehicle(String brand,
                           Dimension dimension,
                           int maxSpeedKm,
                           int weight) {
        this.brand = brand;
        this.dimension = dimension;
        this.maxSpeedKm = maxSpeedKm;
        this.weight = weight;
    }
}
