package ua.kolmakov.multithreaded_storage;

import ua.kolmakov.multithreaded_storage.api.Storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 * <p>
 * MultiThreadAutoDataStorage
 */
public class MultiThreadAutoDataStorage implements Storage{
    private static MultiThreadAutoDataStorage instance = new MultiThreadAutoDataStorage();

    private volatile boolean access;
    private final static Map<Object, Object> storage = new HashMap();

    public static MultiThreadAutoDataStorage getInstance() {
        return (instance == null) ? new MultiThreadAutoDataStorage() : instance;
    }

    private MultiThreadAutoDataStorage() {
        access = true;
    }

    public synchronized void putToStorage(Object key, Object value) {
        while (!access) {
            System.out.println("STORAGE \"put\" can't start");
            try {
                System.out.println("STORAGE \"put\" is waiting");
                wait();
            } catch (InterruptedException e) {
                System.out.println("STORAGE \"put\" interrupted");
            }
        }
        access = false;
        storage.put(key, value);
        access = true;
    }

    public synchronized <T> T getById(Object key) throws ClassCastException {
        while (!access) {
            System.out.println("STORAGE \"get\" can't start");
            try {
                System.out.println("STORAGE \"get\" is waiting");
                wait();
            } catch (InterruptedException e) {
                System.out.println("STORAGE \"get\" interrupted");
            }
        }
        access = false;
        T result = (T) storage.get(key);
        access = true;
        return result;
    }
}
