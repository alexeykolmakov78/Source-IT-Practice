package ua.kolmakov.hometask2.flowers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 30.04.2015.
 * <p>
 * Bouquet.
 */
public class FlowerBouquet {

    private int price;
    private List<Flower> bouquet;

    public FlowerBouquet() {
        this.bouquet = new ArrayList<>();
    }

    public List<Flower> getBouquet() {
        return bouquet;
    }

    public int getPrice() {
        return price;
    }

    public void add(Flower flower) {
        bouquet.add(flower);
        price += flower.getPrice();
    }

    public void show() {
        System.out.println(bouquet.size() + " bouquet");
        for (Flower flower : bouquet) {
            System.out.println(flower);
        }
    }
}
