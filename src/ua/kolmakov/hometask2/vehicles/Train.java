package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 03.05.2015.
 * <p>
 * Train
 */
public class Train extends AbstractLandVehicle implements CargoCarrying, HavingEngine {

    private int quantityOfWagons;
    private int maxCargo;
    private Cargo cargo;
    private Engine engine;

    public Train(String brand,
                 Dimension dimension,
                 int maxSpeedKm,
                 int weight,
                 RoadType roadType,
                 int wheelsAmount,
                 Cargo cargo,
                 int maxCargo,
                 int quantityOfWagons,
                 Engine engine) {
        super(brand, dimension, maxSpeedKm, weight, roadType, wheelsAmount);
        this.cargo = cargo;
        this.maxCargo = maxCargo;
        this.quantityOfWagons = quantityOfWagons;
        this.engine = engine;
    }

    public int getQuantityOfWagons() {
        return quantityOfWagons;
    }

    @Override
    public void move() {
        System.out.println("The Train rides. ");
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
        return false;
    }

    @Override
    public boolean unload() {
        return false;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }
}
