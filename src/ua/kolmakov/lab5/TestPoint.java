package ua.kolmakov.lab5;

/**
 * Created by Kolmakov Alexey on 24.05.2015.
 * <p>
 * TestPoint
 */
public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.printCoordinateQuarter();

        Point p2 = new Point();
        p2.printCoordinateQuarter();

        System.out.println((Point.isSymmetricByZero(p1, p2)) ? "Points are " + p1 + p2 + "symmetric of zero coordinate."
                : "Points are NOT symmetric of zero coordinate.");

        Point p3 = new Point();

        System.out.println((Point.isCollinear(p1, p2, p3)) ? "Points " + p1 + p2 + p3 + "are collinear."
                : "Points "+ p1 + p2 + p3 +"are NOT collinear.");
    }
}
