package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 04.05.2015.
 * <p>
 * Dimension
 */
public class Dimension {

    private int length;
    private int width;
    private int height;

    public Dimension(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
