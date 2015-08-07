package ua.kolmakov.multithreaded_storage;

/**
 * Created by Kolmakov Alexey on 08.07.2015.
 */
public class XMLMain {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Client c = new Client();
            startThread(c);
        }
        JaxbStorageManager sm = new JaxbStorageManager();
        startThread(sm);
    }

    private static void startThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
    }
}
