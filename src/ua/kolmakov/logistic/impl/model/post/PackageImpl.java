package ua.kolmakov.logistic.impl.model.post;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.api.model.post.Package;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class PackageImpl implements Package {
    @Override
    public String getPackageId() {
        return null;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public Address getReceiverAddress() {
        return null;
    }

    @Override
    public Address getSenderAddress() {
        return null;
    }

    @Override
    public FullName getSenderFullName() {
        return null;
    }

    @Override
    public FullName getReceiverFullName() {
        return null;
    }
}
