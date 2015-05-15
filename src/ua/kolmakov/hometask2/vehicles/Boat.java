package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Boat
 */
public class Boat extends AbstractWaterVehicle {

    private int quantityOfSeats;

    public Boat(String brand,
                Dimension dimension,
                int maxSpeedKm, int weight,
                int waterDisplacement,
                int quantityOfSeats) {
        super(brand, dimension, maxSpeedKm, weight, waterDisplacement);
        this.quantityOfSeats = quantityOfSeats;
    }

    public int getQuantityOfSeats() {
        return quantityOfSeats;
    }

    @Override
    public void move() {
        System.out.println("The boat floats. ");
    }
}
