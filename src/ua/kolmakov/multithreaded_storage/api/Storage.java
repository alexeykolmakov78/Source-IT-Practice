package ua.kolmakov.multithreaded_storage.api;

/**
 * Created by Kolmakov Alexey on 02.07.2015.
 */
public interface Storage {

    void putToStorage(Object key, Object value);

    <T> T getById(Object key) throws ClassCastException;
}
