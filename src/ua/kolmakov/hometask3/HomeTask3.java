package ua.kolmakov.hometask3;

import java.util.Arrays;

/**
 * Created by Kolmakov Alexey on 13.05.2015.
 * <p>
 * HomeTask3
 */
public class HomeTask3 {

    public static void main(String[] args) {
        // #1
        System.out.println("One\nTwo\nThree");

        // #2
        // работает для всех даблов
        double n = 2.2259e2;
        System.out.println("Сумма цифр числа " + n + " = " + sumOfDigits(n));

        // #3
        double m = 345.78;
        printMinAndMaxDigits(m);

        // #4
        double a = 248.13579;
        printResultOfFormula(a);
    }

    private static int sumOfDigits(double n) {
        int sum = 0;
        String s = Double.toString(n);
        char next;
        for (int i = 0; i < s.length(); i++) {
            next = s.charAt(i);
            if (Character.isDigit(next)) {
                sum += charToInt(next);
            }
        }
        return sum;
    }

    private static void printMinAndMaxDigits(double n) {
        String s = Double.toString(n);
        s = deletePoint(s);// удаляем точечку
        int digits[] = toDigitArray(s);
        Arrays.sort(digits);
        int min = digits[0];
        int max = digits[digits.length - 1];
        System.out.println("В числе " + n + " минимальная цифра = " + min + " а максимальная цифра = " + max);
    }

    private static void printResultOfFormula(double n) {
        // формула: цифра сотен + цифра 10-ов - цифра единиц + цифра десятых - цифра сотых и т.д числа n.
        int result = 0;
        String s = Double.toString(n);
        s = deletePoint(s);
        int[] digits = toDigitArray(s);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                result += digits[i];
            } else {
                result -= digits[i];
            }
        }
        System.out.println("Результат вычисления формулы длы числа " + n + " = " + result);
    }

    private static String deletePoint(String s) {
        char next;
        for (int i = 0; i < s.length(); i++) {
            next = s.charAt(i);
            if (!Character.isDigit(next)) {
                s = s.substring(0, i) + s.substring(i + 1);
                break;
            }
        }
        return s;
    }

    private static int[] toDigitArray(String s) {
        int result[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = charToInt(s.charAt(i));
        }
        return result;
    }

    private static int charToInt(char arg) {
        return Integer.parseInt(String.valueOf(arg));
    }

}
