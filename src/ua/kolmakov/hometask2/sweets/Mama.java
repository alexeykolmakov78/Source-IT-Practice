package ua.kolmakov.hometask2.sweets;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Mama is a SweetsFactory
 */
public class Mama {

    private String name;

    public Mama(String name) {
        this.name = name;
    }

    public Cake giveMeACake() {
        say("Take the Cake");
        return new Cake();
    }

    public Cake giveMeACake(String taste) {
        say("Take the Cake");
        return new Cake(taste);
    }

    public IceCream giveMeAnIceCream() {
        say("Take the Ice Cream");
        return new IceCream();
    }

    public IceCream giveMeAnIceCream(String taste) {
        say("Take the Ice Cream");
        return new IceCream(taste);
    }

    private void say(String message) {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "I`m Mama " + name ;
    }
}
