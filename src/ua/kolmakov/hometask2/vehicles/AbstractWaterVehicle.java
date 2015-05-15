package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * AbstractWaterVehicle
 */
public abstract class AbstractWaterVehicle extends AbstractVehicle {

    protected int waterDisplacement;

    public AbstractWaterVehicle() {
    }

    public AbstractWaterVehicle(String brand,
                                Dimension dimension,
                                int maxSpeedKm, int weight,
                                int waterDisplacement) {
        super(brand, dimension, maxSpeedKm, weight);
        this.waterDisplacement = waterDisplacement;
    }
}
