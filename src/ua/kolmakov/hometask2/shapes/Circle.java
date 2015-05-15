package ua.kolmakov.hometask2.shapes;

/**
 * Created by Kolmakov Alexey on 01.05.2015.
 * <p>
 * Implementation of AbstractShape for Circles.
 */
public class Circle extends AbstractShape {

    private int radius;

    public Circle(int centerXCoordinate, int centerYCoordinate, int radius) {
        super(centerXCoordinate, centerYCoordinate);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void resize(int dx, int dy) {
        //todo: args validation?
        if (Math.abs(dx) >= Math.abs(dy)) {
            radius += dx;
        } else {
            radius += dy;
        }
    }

    public String toString() {
        return String.format("{Circle: radius = %d, center coordinates: x=%d, y=%d}",
                radius, centerXCoordinate, centerYCoordinate);
    }
}
