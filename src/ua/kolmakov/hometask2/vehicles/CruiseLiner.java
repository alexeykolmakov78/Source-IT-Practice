package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * CruiseLiner
 */
public class CruiseLiner extends AbstractWaterVehicle implements HavingEngine, PassengersCarrying {

    private final int maxQuantityOfPassengers;
    private int quantityOfPassengers;
    private Engine engine;

    public CruiseLiner(String brand,
                       Dimension dimension,
                       int maxSpeedKm,
                       int weight,
                       int waterDisplacement,
                       Engine engine,
                       int maxQuantityOfPassengers,
                       int quantityOfPassengers) {
        super(brand, dimension, maxSpeedKm, weight, waterDisplacement);
        this.engine = engine;
        this.maxQuantityOfPassengers = maxQuantityOfPassengers;
        this.quantityOfPassengers = quantityOfPassengers;
    }

    @Override
    public void move() {
        System.out.println("The CruiseLiner floats. ");
    }

    @Override
    public int getMaxQuantityOfPassengers() {
        return maxQuantityOfPassengers;
    }

    @Override
    public int getQuantityOfPassengers() {
        return quantityOfPassengers;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }
}
