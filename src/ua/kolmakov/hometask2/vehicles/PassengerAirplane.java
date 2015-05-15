package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * PassengerAirplane
 */
public class PassengerAirplane extends AbstractAirVehicle implements HavingEngine, PassengersCarrying {

    private Engine engine;
    private final int maxQuantityOfPassengers;
    private int quantityOfPassengers;

    public PassengerAirplane(String brand,
                             Dimension dimension,
                             int maxSpeedKm,
                             int weight,
                             int maxFlightAttitude,
                             Engine engine,
                             int maxQuantityOfPassengers,
                             int quantityOfPassengers) {
        super(brand, dimension, maxSpeedKm, weight, maxFlightAttitude);
        this.engine = engine;
        this.maxQuantityOfPassengers = maxQuantityOfPassengers;
        this.quantityOfPassengers = quantityOfPassengers;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void move() {
        System.out.println("The PassengerAirplane flies. ");
    }

    @Override
    public int getMaxQuantityOfPassengers() {
        return maxQuantityOfPassengers;
    }

    @Override
    public int getQuantityOfPassengers() {
        return quantityOfPassengers;
    }
}
