package ua.kolmakov.hometask2.sweets;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * IceCream. It is one of the AbstractSweet.
 */
public class IceCream extends AbstractSweet {

    private final String name = "Ice Cream";

    public IceCream() {
    }

    public IceCream(String taste) {
        this(taste, "white");
    }

    public IceCream(String taste, String color) {
        super(taste, color);
    }

    @Override
    public String toString() {
        return super.toString() + name;
    }
}
