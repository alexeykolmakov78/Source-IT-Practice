package ua.kolmakov.lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Kolmakov Alexey on 06.06.2015.
 */

//  1) Выполнить попарное суммирование произвольного конечного ряда чисел следующим образом: на первом этапе
//  суммируются попарно рядом стоящие числа, на втором этапе суммируются результаты первого этапа и т.д. до тех пор,
//  пока не останется одно число.
//  2) Определить класс Stack. Объявить объект класса. Ввести последовательность символов и вывести ее в обратном порядке.
//
//  ДЗ
//  Создать 2 класса - для очередей типа FIFO и LIFO реализовав Queue. Создать программу для его тестирования (class with spvm)


public class CollectionDemo {
    //1)

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        fill(list, 10);
        System.out.println(list);

        while (list.size() > 1) {
            list = pairSum(list);
            System.out.println(list);
        }
        System.out.println(list);

        //2)
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop().toString() + ' ');
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }

    private static void fill(List list, int number) {
        Random rnd = new Random();
        for (int i = 0; i < number; i++) {
            list.add(rnd.nextInt(200));
        }
    }

    private static List<Integer> pairSum(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            int tmp = iterator.next();
            if (iterator.hasNext()) {
                tmp += iterator.next();
            }
            result.add(tmp);
        }
        return result;
    }


}



