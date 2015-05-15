package ua.kolmakov.hometask2.flowers;

/**
 * Created by Kolmakov Alexey on 30.04.2015.
 *
 * Class for testing Flowers and FlowerBouquet.
 */
public class TestFlowers {
    public static void main(String[] args) {

        FlowerBouquet bouquet = new FlowerBouquet();

        bouquet.show();

        bouquet.add(new Rose("red", 30));
        bouquet.add(new Tulip("white", 10));
        bouquet.add(new Chamomile("yellow",2));

        bouquet.show();
        System.out.println("bouquet cost $"+ bouquet.getPrice()+"\n");
    }
}
