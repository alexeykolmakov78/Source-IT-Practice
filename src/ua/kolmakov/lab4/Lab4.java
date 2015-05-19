package ua.kolmakov.lab4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Kolmakov Alexey on 16.05.2015.
 * <p>
 * Lab4
 */
public class Lab4 {
    public static void main(String[] args) {

        // #1. Напишите программу, печатающую количество нулевых элементов в заданном целочисленном массиве.
        System.out.println("#1. Напишите программу, печатающую количество нулевых элементов в заданном целочисленном массиве.");
        final int[] numbers = {1, 2, 3, 0, 5, 0, 5, 0, 23, 556, 6, 5, 234, 8, 0, 0, 42};
        int amountOfZeroElements = 0;
        for (int number : numbers) {
            if (number == 0) {
                amountOfZeroElements += 1;
            }
        }
        System.out.println("Массив целых чисел: " + Arrays.toString(numbers));
        System.out.println("Колличество нулевых элементов в массиве = " + amountOfZeroElements);

        // #2. Напишите программу, печатающую максимальный элемент непустого массива.
        System.out.println("#2. Напишите программу, печатающую максимальный элемент непустого массива.");
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        System.out.println("Наибольший элемент в массиве = " + sortedNumbers[sortedNumbers.length - 1]);

        // #3. есть число int (32 бита), требуется получить массив byte[4](или 4 числа по байту)
        System.out.println("#3. есть число int (32 бита), требуется получить массив byte[4](или 4 числа по байту)");
        int initialNumber = 0b01010101_11011101_01100110_11111111;
        //  to select only 8 right bits;
        final int mask = 0b00000000_00000000_00000000_11111111;
        // for shifting by 8 bits
        final int shift = 8;

        byte[] resultNumbers = new byte[4];
        // for comparing with resultNumbers[];
        byte[] expectedNumbers = {0b01010101, (byte) 0b11011101, 0b01100110, (byte) 0b11111111};
        //                                          ~0b00100010                    ~0b00000000
        System.out.println("Ожидается:  " + Arrays.toString(expectedNumbers));
        // position in resultNumbers[];
        int position;
        for (int i = 0; i < resultNumbers.length; i++) {
            position = resultNumbers.length - 1 - i;
            resultNumbers[position] = (byte) (initialNumber & mask);
            initialNumber >>= shift;
        }
        System.out.println("Получилось: " + Arrays.toString(resultNumbers));

        // #4. есть массив byte[4] (или 4 числа по байту), необходимо получить int
        System.out.println("#4. есть массив byte[4] (или 4 числа по байту), необходимо получить int");
        byte[] initialBytes = {0b01010101, 0b01001100, 0b01110001, 0b01111000};
        //for comparing with resultInt;
        int expectedInt = 0b01010101_01001100_01110001_01111000;
        int resultInt;
        resultInt = makeIntFromBytes(initialBytes);
        System.out.println("Ожидается:  " + Integer.toBinaryString(expectedInt));
        System.out.println("Получилось: " + Integer.toBinaryString(resultInt));

        // #5. Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел из отрезка [10;99].
        //Вывести массив на экран.
        System.out.println("#5. Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел из отрезка [10;99].\n" +
                "Вывести массив на экран.");
        int randomNumbers[][] = new int[8][5];
        Random rnd = new Random();
        int next;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                next = rnd.nextInt(89) + 10;
                randomNumbers[i][j] = next;
            }
        }
        printArray(randomNumbers);

        // #6. Электронные часы показывают время в формате от 00:00 до 23:59.
        // Подсчитать сколько раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация для той,
        // что справа от двоеточия (например, 02:20, 11:11 или 15:51)
        System.out.println("#6. Подсчитать и вывести на экран колличество симметричных часов и минут (например, 02:20, 11:11 или 15:51)");
        int symmetries = 0;
        for (int hours = 0; hours < 24; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (isSymmetry(hours, minutes)) {
                    symmetries++;
                    System.out.println(hours + ":" + minutes);
                }
            }
        }
        System.out.println("Возможно " + symmetries + " вариантов симметричных комбинаций часов и минут");
    }

    private static int makeIntFromBytes(byte[] initialBytes) {
        int result = 0;
        for (byte initialByte : initialBytes) {
            result <<= 8;
            result |= initialByte;
        }
        return result;
    }

    private static void printArray(int[][] array) {
        for (int subArray[] : array) {
            System.out.println(Arrays.toString(subArray));
        }
    }

    private static boolean isSymmetry(int first, int second) {
        return (first / 10 == second % 10 && second / 10 == first % 10);
    }
}
