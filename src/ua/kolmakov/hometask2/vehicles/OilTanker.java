package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * OilTanker
 */
public class OilTanker extends AbstractWaterVehicle implements HavingEngine, CargoCarrying {

    private Engine engine;
    private Cargo cargo;
    private final int maxCargo;

    public OilTanker(String brand,
                     Dimension dimension,
                     int maxSpeedKm, int weight,
                     int waterDisplacement,
                     Cargo cargo, Engine engine,
                     int maxCargo) {
        super(brand, dimension, maxSpeedKm, weight, waterDisplacement);
        this.cargo = cargo;
        this.engine = engine;
        this.maxCargo = maxCargo;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void move() {
        System.out.println("The OilTanker floats. ");
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
}
