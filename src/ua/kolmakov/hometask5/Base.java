package ua.kolmakov.hometask5;

/**
 * Created by Kolmakov Alexey on 25.05.2015.
 * <p>
 * Base
 */
public class Base {

    protected Number value;

    Base(int value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Number multipleValue(Number n){
        //todo
        return null;
    }

    public Number divValue(Number n){
        //todo
        return null;
    }
    public Number avgValue(Number n){
        //todo
        return null;
    }

    @Override
    public String toString() {
        return "Base{" + value + "} ";
    }
}
