package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Bike
 */
public class Bike extends AbstractLandVehicle {

    private final String type;

    public Bike(String brand,
                Dimension dimension,
                int maxSpeedKm,
                int weight,
                RoadType roadType,
                int wheelsAmount,
                String type) {
        super(brand, dimension, maxSpeedKm, weight, roadType, wheelsAmount);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void move() {
        System.out.println("The Bike rides. ");
    }
}
