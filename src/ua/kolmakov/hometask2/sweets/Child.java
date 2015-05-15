package ua.kolmakov.hometask2.sweets;

/**
 * Created by Kolmakov Alexey on 06.05.2015.
 * <p>
 * Child
 */
public class Child {

    private String name;
    private Mama mama;
    private AbstractSweet sweet;

    public Child(String name, Mama mama) {
        this.mama = mama;
        this.name = name;
    }

    public Mama getMama() {
        return mama;
    }

    public void setMama(Mama mama) {
        this.mama = mama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractSweet getSweet() {
        return sweet;
    }

    public void setSweet(AbstractSweet sweet) {
        this.sweet = sweet;
    }

    public void askIceCream() {
        say("Give me an Ice Cream.");
        sweet = mama.giveMeAnIceCream();
    }

    public void askIceCream(String taste) {
        say("Give me a " + taste + " Ice Cream.");
        sweet = mama.giveMeAnIceCream(taste);
    }

    public void askCake() {
        say("Give me a Cake.");
        sweet = mama.giveMeACake();
    }

    public void askCake(String taste) {
        say("Give me a " + taste + " Cake.");
        sweet = mama.giveMeACake(taste);
    }

    public void exchangeSweet(Child otherChild) {
        AbstractSweet tmp = this.getSweet();
        this.setSweet(otherChild.getSweet());
        otherChild.setSweet(tmp);
        say(this.name + " exchanges Sweets with " + otherChild.getName()+".");
    }

    private void say(String message) {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "I`m child " + name + " and " + (sweet == null ? "I have no sweets. " : ("I have a " + sweet));
    }
}
