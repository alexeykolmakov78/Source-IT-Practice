package ua.kolmakov.hometask2.shapes;

/**
 * Created by Kolmakov Alexey on 01.05.2015.
 * <p>
 * Abstract class for 2d shapes.
 */
public abstract class AbstractShape implements Shape {

    protected int centerXCoordinate;
    protected int centerYCoordinate;

    public AbstractShape(int centerXCoordinate, int centerYCoordinate) {
        this.centerXCoordinate = centerXCoordinate;
        this.centerYCoordinate = centerYCoordinate;
    }

    public int getCenterXCoordinate() {
        return centerXCoordinate;
    }

    public void setCenterXCoordinate(int centerXCoordinate) {
        this.centerXCoordinate = centerXCoordinate;
    }

    public int getCenterYCoordinate() {
        return centerYCoordinate;
    }

    public void setCenterYCoordinate(int centerYCoordinate) {
        this.centerYCoordinate = centerYCoordinate;
    }

    public void create() {
        //todo: what the "create()" have to do?
        System.out.println(this);
    }

    public void move(int dx, int dy) {
        // todo: args validation
        centerXCoordinate += dx;
        centerYCoordinate += dy;
    }
}
