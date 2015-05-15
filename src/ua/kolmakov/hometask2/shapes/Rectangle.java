package ua.kolmakov.hometask2.shapes;

/**
 * Created by Kolmakov Alexey on 01.05.2015.
 * <p>
 * Implementation of AbstractShape for Rectangles.
 */
public class Rectangle extends AbstractShape {

    private int width;
    private int height;

    public Rectangle(int centerXCoordinate, int centerYCoordinate, int height, int width) {
        super(centerXCoordinate, centerYCoordinate);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void resize(int dx, int dy) {
        //todo: args validation?
        width += dx;
        height += dy;
    }

    public String toString() {
        return String.format("{Rectangle: width = %d, height = %d, center coordinates: x=%d, y=%d}",
                width, height, centerXCoordinate, centerYCoordinate);
    }
}
