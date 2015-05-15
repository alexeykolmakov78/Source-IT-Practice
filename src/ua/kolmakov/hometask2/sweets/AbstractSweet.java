package ua.kolmakov.hometask2.sweets;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * AbstractSweet
 */
public abstract class AbstractSweet {

    protected final String taste;
    protected final String color;

    public AbstractSweet() {
        this("", "");
    }

    public AbstractSweet(String taste) {
        this(taste, "");
    }

    public AbstractSweet(String taste, String color) {
        this.taste = taste;
        this.color = color;
    }

    @Override
    public String toString() {
        String colorWithSpace = color;
        String tasteWithSpace = taste;
        if (taste != "") {
            colorWithSpace = color.concat(" ");
        }
        if (color != "") {
            tasteWithSpace = taste.concat(" ");
        }
        return colorWithSpace + tasteWithSpace;
    }
}
