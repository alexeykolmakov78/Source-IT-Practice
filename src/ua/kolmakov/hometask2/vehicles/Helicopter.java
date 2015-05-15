package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Helicopter
 */
public class Helicopter extends AbstractAirVehicle implements HavingEngine {

    private Engine engine;

    private int quantityOfWings;

    public Helicopter(String brand,
                      Dimension dimension,
                      int maxSpeedKm,
                      int weight,
                      int maxFlightAttitude,
                      Engine engine,
                      int quantityOfWings) {
        super(brand, dimension, maxSpeedKm, weight, maxFlightAttitude);
        this.engine = engine;
        this.quantityOfWings = quantityOfWings;
    }

    public int getQuantityOfWings() {
        return quantityOfWings;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void move() {
        System.out.println("The Helicopter flies. ");
    }
}
