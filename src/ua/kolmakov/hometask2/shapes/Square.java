package ua.kolmakov.hometask2.shapes;

/**
 * Created by Kolmakov Alexey on 01.05.2015.
 * <p>
 * Implementation of Rectangle for Squares.
 */
public class Square extends Rectangle {

    private int side;

    public Square(int centerXCoordinate, int centerYCoordinate, int side) {
        super(centerXCoordinate, centerYCoordinate, side, side);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public void resize(int dx, int dy) {
        //todo: args validation?
        if (Math.abs(dx) >= Math.abs(dy)) {
            side += dx;

        } else {
            side += dy;
        }
    }

    public String toString() {
        return String.format("{Square: side = %d, center coordinates: x=%d, y=%d}",
                side, centerXCoordinate, centerYCoordinate);
    }
}
