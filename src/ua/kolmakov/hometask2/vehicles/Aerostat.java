package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Aerostat
 */
public class Aerostat extends AbstractAirVehicle implements PassengersCarrying {

    private int quantityOfPassengers;
    private int maxQuantityOfPassengers;

    public Aerostat(String brand,
                    Dimension dimension,
                    int maxSpeedKm,
                    int weight,
                    int maxFlightAttitude,
                    int maxQuantityOfPassengers,
                    int quantityOfPassengers) {
        super(brand, dimension, maxSpeedKm, weight, maxFlightAttitude);
        this.maxQuantityOfPassengers = maxQuantityOfPassengers;
        this.quantityOfPassengers = quantityOfPassengers;
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
    public void move() {
        System.out.println("The Aerostat flies. ");
    }
}
