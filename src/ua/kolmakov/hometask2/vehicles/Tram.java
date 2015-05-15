package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 03.05.2015.
 * <p>
 * Tram
 */
public class Tram extends AbstractLandVehicle implements HavingEngine, PassengersCarrying {

    private int quantityOfWagons;
    private int quantityOfPassengers;
    private int maxQuantityOfPassengers;
    private Engine engine;

    public Tram(String brand,
                Dimension dimension,
                int maxSpeedKm, int weight,
                RoadType roadType,
                int wheelsAmount,
                int maxQuantityOfPassengers,
                int quantityOfPassengers,
                int quantityOfWagons,
                Engine engine) {
        super(brand, dimension, maxSpeedKm, weight, roadType, wheelsAmount);
        this.maxQuantityOfPassengers = maxQuantityOfPassengers;
        this.quantityOfPassengers = quantityOfPassengers;
        this.quantityOfWagons = quantityOfWagons;
        this.engine = engine;
    }

    @Override
    public void move() {
        System.out.println("The Tram rides. ");
    }

    @Override
    public int getMaxQuantityOfPassengers() {
        return maxQuantityOfPassengers;
    }

    @Override
    public int getQuantityOfPassengers() {
        return quantityOfPassengers;
    }

    public int getQuantityOfWagons() {
        return quantityOfWagons;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }
}
