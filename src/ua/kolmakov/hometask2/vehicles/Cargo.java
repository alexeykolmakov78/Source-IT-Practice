package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 04.05.2015.
 * <p>
 * Cargo
 */
public class Cargo {

    private String name;
    private int weight;

    public Cargo(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
