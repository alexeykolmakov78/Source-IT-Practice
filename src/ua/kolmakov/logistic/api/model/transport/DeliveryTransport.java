package ua.kolmakov.logistic.api.model.transport;

import ua.kolmakov.logistic.api.model.post.PostOffice;

/**
 * Created by Denis on 5/25/2015.
 */
public interface DeliveryTransport {
    String getId();

    Type getType();

    PostOffice getStartPostOffice();

    PostOffice getDestinationPostOffice();

    double getPrice();

    double getDistance();

    enum Type {
        SEA(10, 2.5), AIR(50, 25.2), LAND(18, 1.26);

        private int speed;
        private double costPerMile;

        Type(int speed, double costPerMile) {
            this.speed = speed;
            this.costPerMile = costPerMile;
        }

        public int getSpeed() {
            return speed;
        }

        public double getCostPerMile() {
            return costPerMile;
        }
    }
}
