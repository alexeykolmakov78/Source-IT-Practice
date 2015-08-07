package ua.kolmakov.hometask2.flowers;

/**
 * Created by Kolmakov Alexey on 30.04.2015.
 *
 * Abstract Flower.
 */
public abstract class Flower {

    private final String name;
    private final String color;
    private int price;

    protected Flower(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return color + " " + name;
    }
}
