package ua.kolmakov.lab5;

import java.util.Scanner;

/**
 * Created by Kolmakov Alexey on 24.05.2015.
 * <p>
 * Point
 */

/*1) Создайте в классе метод, который будет выводить на экран сообщение о том, в какой координатной четверти лежит точка.
* 2) Создайте в классе метод, проверяющий, являются ли две точки симметричными относительно начала отсчёта.
* 3) Измените в классе конструктор по умолчанию таким образом, чтобы начальные координаты точки при её создании пользователь
*    задавал с клавиатуры.
* 4) Создайте в классе метод, проверяющий, являются ли три точки коллинеарными (т.е. лежащими на одной прямой).
* 5) Вместо представленного метода equalsPoint перегрузите в классе методы equals и hashCode.
*/
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(this);
    }

    public static Point inputPointFromKeyboard() {
        boolean inputError = false;
        int x = 0;
        int y = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input X , Y :");
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
            y =scanner.nextInt();
        } else {
            inputError = true;
        }
        if (inputError) {
            System.out.println("The coordinates must be integer!!!");
            return null;
            //  throw new IllegalArgumentException("Point():  The coordinates must be integer!!!");
        } else {
            System.out.println();
            return new Point(x, y);
        }
    }

    public static boolean isSymmetricByZero(Point p1, Point p2) {
        return (p1.x == -p2.x && p1.y == -p2.y);
    }

    public static boolean isCollinear(Point p1, Point p2, Point p3) {
        // уравнение пямой: y = k * x + b;
        if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) {
            System.out.println("All points must be different!!!");
            //  throw new IllegalArgumentException("isCollinear(...):  All points must be different!!!");
            return false;
        } else {
            int k;
            int b;
            k = (p1.y - p2.y) / (p1.x - p2.x);
            b = p2.y - k * p2.x;
            return (p3.y == k * p3.x + b);
        }
    }

    public void printCoordinateQuarter() {
        System.out.println("The point is in the " + this.getCoordinateQuarter() + " coordinate quarter.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point{" + x + ", " + y + "} ";
    }

    private CoordinateQuarter getCoordinateQuarter() {
        if (x >= 0 && y >= 0) {
            return CoordinateQuarter.TOP_RIGHT;
        } else if (x < 0 && y >= 0) {
            return CoordinateQuarter.TOP_LEFT;
        } else if (x >= 0 && y < 0) {
            return CoordinateQuarter.BOTTOM_RIGHT;
        } else // if (x < 0 && y < 0)
            return CoordinateQuarter.BOTTOM_LEFT;
    }

    enum CoordinateQuarter {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }
}
