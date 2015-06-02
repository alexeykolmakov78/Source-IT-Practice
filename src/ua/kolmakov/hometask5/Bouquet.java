package ua.kolmakov.hometask5;

import ua.kolmakov.hometask2.flowers.Flower;

import java.util.Arrays;

/**
 * Created by Kolmakov Alexey on 25.05.2015.
 * <p>
 * Bouquet
 */
/*
   1)Создайте класс-обертку для массива, который бы делал:
      - инициализацию массива с учетом начального размера;
      - уменьшение размера массива при его переполнении;
      - добавление/удаление элементов массива (со сжатием массива);
      - вычислял min, max, avg значения элементов массива.

    Доп условия:
      - Массив должен быть строго определенного типа,
      для этого создайте иерархию классов по вашему усмотрению и корень вашей иерархии будет типом массива в обертке.

*/

public class Bouquet {
    private static final int DEFAULT_SIZE = 5;
    private static final int DEFAULT_RESIZE_STEP = 5;

    int resizeStep;
    private Flower[] flowers;
    private int lastIndex;

    public Bouquet() {
        this(DEFAULT_SIZE, DEFAULT_RESIZE_STEP);
    }

    public Bouquet(int size) {
        this(size, DEFAULT_RESIZE_STEP);
    }

    public Bouquet(int size, int resizeStep) {
        flowers = new Flower[size];
        lastIndex = 0;
        this.resizeStep = resizeStep;
    }

    public void add(Flower value) {
        add(value, lastIndex);
    }

    public void add(Flower value, int index) {
        if (lastIndex >= flowers.length) {
            increaseSize();
        }
        if (index >= lastIndex) {
            flowers[lastIndex] = value;

        } else { //if(index < flowers.length)
            // moves all elements that are right-side of the index (including index) on the one position to the right.
            System.arraycopy(flowers, index, flowers, index + 1, lastIndex - index);
            flowers[index] = value;
        }
        lastIndex++;
    }

    public void remove() {
        remove(lastIndex);
    }

    public void remove(int index) {
        lastIndex--;
        if (index >= lastIndex) {
            flowers[lastIndex] = null;
        } else { //if(index > flowers.length)
            // moves all elements that are right-side of the index on the one position to the left.
            System.arraycopy(flowers, index + 1, flowers, index, lastIndex - index);
            flowers[lastIndex] = null;
        }
        if (lastIndex <= flowers.length - resizeStep) {
            decreaseSize();
        }
    }

    public int totalPrice() {
        int sum = 0;
        for (Flower flower : flowers) {
            if (flower != null) {
                sum += flower.getPrice();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Bouquet{" + Arrays.toString(flowers) + "} ";
    }

    private void increaseSize() {
        int newSize = flowers.length + resizeStep;
        resize(newSize);
    }

    private void decreaseSize() {
        int newSize = flowers.length - resizeStep;
        resize(newSize);
    }

    private void resize(int size) {
        Flower[] newArray = new Flower[size];
        System.arraycopy(flowers, 0, newArray, 0, lastIndex/*flowers.length*/);
        flowers = newArray;
    }
}
