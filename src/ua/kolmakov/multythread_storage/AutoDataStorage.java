package ua.kolmakov.multythread_storage;

import ua.kolmakov.multythread_storage.api.Storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 * <p>
 * AutoDataStorage
 */
public class AutoDataStorage implements Storage{
    private static AutoDataStorage instance = new AutoDataStorage();

    private volatile boolean access;
    private final static Map<Object, Object> storage = new HashMap();

    public static AutoDataStorage getInstance() {
        return (instance == null) ? new AutoDataStorage() : instance;
    }

    private AutoDataStorage() {
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
//        notify();
        access = true;
        return result;
    }
}
