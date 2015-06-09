package ua.kolmakov.logistic.impl.service;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.service.SenderService;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

    public PostOffice getPostOfficeByAddress(Address address) {
        List<PostOffice> allOffices = getById("postOffices");
        for (PostOffice item : allOffices) {
            if (item.getAddress().equals(address)) {
                return item;
            }
        }
        return null;
    }

    private static class InstanceHolder {
        private static final Storage instance = new Storage();
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
}
