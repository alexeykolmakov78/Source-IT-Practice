package ua.kolmakov.hometask2.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 01.05.2015.
 * <p>
 * Class for testing of all Shape implementations.
 */
public class TestShapes {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10, 10, 20, 30));
        shapes.add(new Square(10, 10, 40));
        shapes.add(new Rectangle(3, 8, 20, 30));
        shapes.add(new Circle(60, 80, 30));
        shapes.add(new Circle(8, 9, 99));
        shapes.forEach(Shape::create);

        System.out.println("====================================================");

        Shape circle = new Circle(20, 20, 20);
        System.out.println("new Circle(20, 20, 20)");
        circle.create();

        circle.move(5, 15);
        System.out.println("circle.move(5, 15)");
        circle.create();

        circle.resize(33, 55);
        System.out.println("circle.resize(33, 55)");
        circle.create();
    }
}
