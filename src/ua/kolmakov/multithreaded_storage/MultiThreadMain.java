package ua.kolmakov.multithreaded_storage;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class MultiThreadMain {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Client c = new Client();
            startThread(c);
        }
        StorageManager sm = new StorageManager();
        startThread(sm);
    }

    private static void startThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
    }
}

