package ua.kolmakov.hometask7;

import java.util.ListIterator;

/**
 * Created by Kolmakov Alexey on 09.06.2015.
 */

//  Создать 2 класса - для очередей типа FIFO и LIFO реализовав Queue. Создать программу для его тестирования (class with spvm)

public class TestQueue {
    public static void main(String[] args) {

        System.out.println("Create FIFO on 5 elements");
        FIFO fifo = new FIFO(5);//Queue
        System.out.println("FIFO offer(..) 5 elements: "
                + fifo.offer(1) + "," + fifo.offer(2) + ","
                + fifo.offer(3) + "," + fifo.offer(4) + ","
                + fifo.offer(5) + "," + fifo);
        System.out.println("FIFO try to offer(..) 6 element: " + fifo.offer(6) + " " + fifo);
        System.out.println("FIFO remove():  " + fifo.remove() + "   " + fifo);
        System.out.println("FIFO poll():    " + fifo.poll() + "   " + fifo);
        System.out.println("FIFO element(): " + fifo.element() + "   " + fifo);
        System.out.println("FIFO peek():    " + fifo.peek() + "   " + fifo);

        System.out.println("FIFO try to add() element by index: ");
        try {
            fifo.add(2, 2);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }

        System.out.println("FIFO try to set() element by index: ");
        try {
            fifo.set(2, 2);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }

        System.out.println("FIFO try to get() element by index: ");
        try {
            fifo.get(8);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }
        System.out.println("???????????????????????????????????????????????????????????????????????");
        ListIterator listIterator = fifo.listIterator();

        System.out.print("FIFO listIterator try to add() element by index: ");
        try {
            listIterator.add(9);
            System.out.println(fifo);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }

        System.out.println("FIFO ListIterator try to next() element " +listIterator.next()+"  "+ fifo);
        System.out.println("???????????????????????????????????????????????????????????????????????");








        System.out.println("=======================================================================");
        System.out.println("Create LIFO on 5 elements");
        LIFO lifo = new LIFO(5);//Queue
        System.out.println("LIFO offer(..) 5 elements: "
                + lifo.offer(1) + "," + lifo.offer(2) + ","
                + lifo.offer(3) + "," + lifo.offer(4) + ","
                + lifo.offer(5) + "," + lifo);
        System.out.println("LIFO try to offer(..) 6 element: " + lifo.offer(6) + " " + lifo);
        System.out.println("LIFO remove():  " + lifo.remove() + "   " + lifo);
        System.out.println("LIFO poll():    " + lifo.poll() + "   " + lifo);
        System.out.println("LIFO element(): " + lifo.element() + "   " + lifo);
        System.out.println("LIFO peek():    " + lifo.peek() + "   " + lifo);

        System.out.println("LIFO try to add() element by index: ");
        try {
            lifo.add(2, 2);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }

        System.out.println("LIFO try to set() element by index: ");
        try {
            lifo.set(2, 2);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }

        System.out.println("LIFO try to get() element by index: ");
        try {
            lifo.get(8);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
        }


    }


}
