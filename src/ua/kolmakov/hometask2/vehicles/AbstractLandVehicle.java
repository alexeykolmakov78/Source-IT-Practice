package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 04.05.2015.
 * <p>
 * AbstractLandVehicle
 */
public abstract class AbstractLandVehicle extends AbstractVehicle {

    protected int wheelsAmount;
    protected RoadType roadType;

    public AbstractLandVehicle() {
    }

    public AbstractLandVehicle(String brand,
                               Dimension dimension,
                               int maxSpeedKm,
                               int weight,
                               RoadType roadType,
                               int wheelsAmount) {
        super(brand, dimension, maxSpeedKm, weight);
        this.roadType = roadType;
        this.wheelsAmount = wheelsAmount;
    }


}
