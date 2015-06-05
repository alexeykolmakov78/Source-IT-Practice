package ua.kolmakov.logistic.impl.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Denis on 5/25/2015.
 */
public class Storage {
    private Map storage;

    private Storage() {
        this.storage = new LinkedHashMap<>();
    }

    public static Storage getInstance() {
        return InstanceHolder.instance;
    }

    public void putToStorage(Object id, Object value) {
        this.storage.put(id, value);
    }

    public <T> T getById(Object id) throws ClassCastException {
        return (T) this.storage.get(id);
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        Iterator i = storage.entrySet().iterator();
        while (i.hasNext()) {
            stb.append(i.next().toString()).append("\n");
        }
        return stb.toString();
    }

    private static class InstanceHolder {
        private static final Storage instance = new Storage();
    }
}
