package ua.kolmakov.logistic.api.model.post;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.api.model.transport.Transit;
import ua.kolmakov.logistic.impl.model.post.PackageImpl;

import java.util.List;

/**
 * Created by Denis on 5/25/2015.
 */
public interface Package {
    String getPackageId();

    int getWeight();

    Type getType();

    Address getReceiverAddress();

    Address getSenderAddress();

    FullName getSenderFullName();

    FullName getReceiverFullName();

    void addStamp(Stamp stamp);


    PackageImpl.Status getStatus();

    void setStatus(Status status);

    Transit getTransit();

    void setTransit(Transit transit);

    List<Stamp> getStamps();


    enum Status {
        READY, SENT, RECEIVED, FAILED
    }

    /**
     * http://www.ups.com/worldshiphelp/WS15/RUS/AppHelp/Codes/Package_Type_Codes.htm
     */
    enum Type {
        T_CP("Место груза"), T_30("Палета"), T_10("Коробка UPS 10 кг", 10),
        T_25("Коробка UPS 25 кг", 25), T_27("Средняя коробка UPS Express");

        private final String description;
        private final int maxWeight;

        Type(String description) {
            this(description, 0);
        }

        Type(String description, int maxWeight) {
            this.description = description;
            this.maxWeight = maxWeight;
        }

        public String getDescription() {
            return description;
        }

        public int getMaxWeight() {
            return maxWeight;
        }
    }
}
