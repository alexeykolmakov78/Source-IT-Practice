package ua.kolmakov.hometask5;

import java.util.Arrays;

/**
 * Created by Kolmakov Alexey on 25.05.2015.
 * <p>
 * ArrayWrapper
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

    К примеру: есть базовый обьект Base у которого есть методы: Number getValue(), setValue(Number n),
    multipleValue(Number n), divValue(Number n), ...
    Обертка должна использовать определенные в Base методы для вычисления min, max, avg значений.
*/

public class ArrayWrapper {
    private static final int DEFAULT_SIZE = 5;
    private static final int DEFAULT_RESIZE_STEP = 5;

    int resizeStep;
    private Base[] array;
    private int lastIndex;

    public ArrayWrapper() {
        this(DEFAULT_SIZE, DEFAULT_RESIZE_STEP);
    }

    public ArrayWrapper(int size) {
        this(size, DEFAULT_RESIZE_STEP);
    }

    public ArrayWrapper(int size, int resizeStep) {
        array = new Base[size];
        lastIndex = 0;
        this.resizeStep = resizeStep;
    }

    public void add(Base value) {
        add(value, lastIndex);
    }

    public void add(Base value, int index) {
        if (lastIndex >= array.length) {
            increaseSize();
        }
        if (index >= lastIndex) {
            array[lastIndex] = value;

        } else { //if(index < array.length)
            // moves all elements that are right-side of the index (including index) on the one position to the right.
            System.arraycopy(array, index, array, index + 1, lastIndex - index);
            array[index] = value;
        }
        lastIndex++;
    }

    public void remove() {
        remove(lastIndex);
    }

    public void remove(int index) {
        lastIndex--;
        if (index >= lastIndex) {
            array[lastIndex] = null;
        } else { //if(index > array.length)
            // moves all elements that are right-side of the index on the one position to the left.
            System.arraycopy(array, index +1, array, index, lastIndex - index);
            array[lastIndex] = null;
        }
        if (lastIndex <= array.length - resizeStep) {
            decreaseSize();
        }
    }

    @Override
    public String toString() {
        return "ArrayWrapper{" + Arrays.toString(array) + "} ";
    }

    private void increaseSize() {
        int newSize = array.length + resizeStep;
        resize(newSize);
    }

    private void decreaseSize() {
        int newSize = array.length - resizeStep;
        resize(newSize);
    }

    private void resize(int size) {
        Base[] newArray = new Base[size];
        System.arraycopy(array, 0, newArray, 0, lastIndex/*array.length*/);
        array = newArray;
    }

    public Number min() {
        // todo
        return null;
    }

    public Number max() {
        // todo
        return null;
    }

    public Number avg() {
        // todo
        return null;
    }


}
