package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Engine
 */
public class Engine {

    int power;
    EngineType engineType;

    public Engine(EngineType engineType, int power) {
        this.engineType = engineType;
        this.power = power;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }
}


