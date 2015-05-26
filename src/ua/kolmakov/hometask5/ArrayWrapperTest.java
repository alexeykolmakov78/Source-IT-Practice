package ua.kolmakov.hometask5;

/**
 * Created by Kolmakov Alexey on 25.05.2015.
 * <p>
 * ArrayWrapperTest
 */
public class ArrayWrapperTest {
    public static void main(String[] args) {

        ArrayWrapper wrapper = new ArrayWrapper();

        wrapper.add(new Base(1));
        wrapper.add(new Base(2));
        wrapper.add(new Base(3));
        wrapper.add(new Base(4));
        wrapper.add(new Base(5));
        System.out.println(wrapper);

        wrapper.add(new Base(6));
        System.out.println(wrapper);

        wrapper.add(new Base(7), 3);
        System.out.println(wrapper);

        wrapper.remove();
        System.out.println(wrapper);

        wrapper.remove(4);
        System.out.println(wrapper);

        wrapper.add(new Base(8),0);
        System.out.println(wrapper);

    }
}
