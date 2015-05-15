package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * AbstractAirVehicle
 */
public abstract class AbstractAirVehicle extends AbstractVehicle {

    protected int maxFlightHeight;

    public AbstractAirVehicle() {
    }

    public AbstractAirVehicle(String brand,
                              Dimension dimension,
                              int maxSpeedKm,
                              int weight,
                              int maxFlightHeight) {
        super(brand, dimension, maxSpeedKm, weight);
        this.maxFlightHeight = maxFlightHeight;
    }
}
