package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 04.05.2015.
 * <p>
 * Truck
 */
public class Truck extends AbstractLandVehicle implements CargoCarrying, HavingEngine {

    private final int maxCargo;
    private Cargo cargo;
    private Engine engine;

    //что делать с такими конструкторами?
    public Truck(String brand,
                 Dimension dimension,
                 int maxSpeedKm,
                 int weight,
                 RoadType roadType,
                 int wheelsAmount,
                 Cargo cargo,
                 Engine engine,
                 int maxCargo) {
        super(brand, dimension, maxSpeedKm, weight, roadType, wheelsAmount);
        this.cargo = cargo;
        this.engine = engine;
        this.maxCargo = maxCargo;
    }

    @Override
    public void move() {
        System.out.println("The Truck rides. ");
    }

    @Override
    public int getMaxCargo() {
        return maxCargo;
    }

    @Override
    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public boolean load() {
        //todo
        return false;
    }

    @Override
    public boolean unload() {
        //todo
        return false;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    public String toString() {
        return "Brand = " + brand + ";  wheelsAmount = " + wheelsAmount + "; maxSpeed = " + maxSpeedKm;
    }
}
