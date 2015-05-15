package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 03.05.2015.
 * <p>
 * Car
 */
public class Car extends AbstractLandVehicle implements HavingEngine {

    private CarBody carBody;
    private Engine engine;

    public Car(String brand,
               Dimension dimension,
               int maxSpeedKm,
               int weight,
               RoadType roadType,
               int wheelsAmount,
               CarBody carBody,
               Engine engine) {
        super(brand, dimension, maxSpeedKm, weight, roadType, wheelsAmount);
        this.carBody = carBody;
        this.engine = engine;
    }

    @Override
    public void move() {
        System.out.println("The Car rides. ");
    }

    @Override
    public Engine getEngine() {
        return engine;
    }
}
