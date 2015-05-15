package ua.kolmakov.hometask2.sweets;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * TestSweets
 */
public class Cake extends AbstractSweet {

    private final String name = "Cake";

    public Cake() {
    }

    public Cake(String taste) {
        this(taste, "yellow");
    }

    public Cake(String taste, String color) {
        super(taste, color);
    }

    @Override
    public String toString() {
        return super.toString() + name;
    }
}
