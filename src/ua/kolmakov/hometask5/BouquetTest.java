package ua.kolmakov.hometask5;

import ua.kolmakov.hometask2.flowers.Chamomile;
import ua.kolmakov.hometask2.flowers.Rose;
import ua.kolmakov.hometask2.flowers.Tulip;

/**
 * Created by Kolmakov Alexey on 25.05.2015.
 * <p>
 * BouquetTest
 */
public class BouquetTest {
    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet();

        bouquet.add(new Tulip("red", 10));
        bouquet.add(new Chamomile("white", 5));
        bouquet.add(new Tulip("yellow", 10));
        bouquet.add(new Rose("rose", 20));
        bouquet.add(new Rose("rose", 20));
        System.out.println(bouquet);
        System.out.println("cost = "+ bouquet.totalPrice());

        bouquet.add(new Tulip("red", 10));
        System.out.println(bouquet);
        System.out.println("cost = "+ bouquet.totalPrice());

        bouquet.add(new Tulip("yellow", 10));
        System.out.println(bouquet);
        System.out.println("cost = "+ bouquet.totalPrice());

        bouquet.remove();
        System.out.println(bouquet);
        System.out.println("cost = "+ bouquet.totalPrice());

        bouquet.remove(4);
        System.out.println(bouquet);
        System.out.println("cost = "+ bouquet.totalPrice());

        bouquet.add(new Tulip("red", 10));
        System.out.println(bouquet);
        System.out.println("cost = "+ bouquet.totalPrice());
    }
}
