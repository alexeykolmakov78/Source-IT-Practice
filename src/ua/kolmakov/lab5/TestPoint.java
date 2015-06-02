package ua.kolmakov.lab5;

/**
 * Created by Kolmakov Alexey on 24.05.2015.
 * <p>
 * TestPoint
 */
public class TestPoint {
    public static void main(String[] args) {
        Point p1 = Point.inputPointFromKeyboard();
        if (p1 != null) {
            p1.printCoordinateQuarter();
        }

        Point p2 = Point.inputPointFromKeyboard();
        if (p2 != null) {
            p2.printCoordinateQuarter();

        }
        if (p1 != null && p2 != null) {
            System.out.println((Point.isSymmetricByZero(p1, p2)) ? "Points are " + p1 + p2 + "symmetric of zero coordinate."
                    : "Points are NOT symmetric of zero coordinate.");
        }

        Point p3 = Point.inputPointFromKeyboard();
        if (p1 != null && p2 != null && p3 != null) {
            System.out.println((Point.isCollinear(p1, p2, p3)) ? "Points " + p1 + p2 + p3 + "are collinear."
                    : "Points " + p1 + p2 + p3 + "are NOT collinear.");
        }
    }
}
