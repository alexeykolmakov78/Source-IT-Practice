package ua.kolmakov.hometask2.shapes;

/**
 * Created by Kolmakov Alexey on 02.05.2015.
 * <p>
 * Interface Shape.
 */
public interface Shape {

    void create();

    void move(int dx, int dy);

    void resize(int dx, int dy);
}
