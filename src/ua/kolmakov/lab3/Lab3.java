package ua.kolmakov.lab3;

/**
 * Created by Kolmakov Alexey on 12.05.2015.
 *
 * Lab3
 */
public class Lab3 {


    public static void main(String[] args) {

        // 1
        int q = 113;
        int w = 23;
        System.out.println("задача 1");
        System.out.println("q =" + q + " w = " + w);
        System.out.println("q/w = " + q / w + " с остатком " + q % w);

        // 2
        int n = 35;
        System.out.println("задача 2");
        System.out.println("Сумма цифр числа " + n + " = " + (n / 10 + n % 10));

        // 3
        double a = 123.945;
        System.out.println("задача 3");
        System.out.println(Math.round(a));

        // 4
        int b = 204;
        System.out.println("задача 4");
        System.out.println("сумма цифр числа " + b + " = " + sumOfDigits(b));
    }

    private static int sumOfDigits(int b) {
        int result = 0;
        while (b  > 0) {
            result += b % 10;
            b /= 10;
        }
        return result;
    }


}
