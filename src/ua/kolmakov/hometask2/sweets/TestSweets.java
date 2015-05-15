package ua.kolmakov.hometask2.sweets;

/**
 * Created by Kolmakov Alexey on 07.05.2015.
 *
 * TestSweets
 */
public class TestSweets {

    public static void main(String[] args) {

        Mama lena = new Mama("Lena");
        System.out.println(lena);

        Child vova = new Child("Vova", lena);
        System.out.println(vova);
        vova.askCake();
        System.out.println(vova);

        Child sonja = new Child("Sonja", lena);
        System.out.println(sonja);
        sonja.askIceCream("strawberry");
        System.out.println(sonja);

        vova.exchangeSweet(sonja);
        System.out.println(sonja);
        System.out.println(vova);
    }

}
