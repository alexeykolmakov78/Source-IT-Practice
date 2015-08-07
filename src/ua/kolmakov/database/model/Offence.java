package ua.kolmakov.database.model;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Offence {
    private int id;
    private Date date;
    private Type type;

    public Offence(int id,Date date, Type type) {
        this.date = date;
        this.type = type;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    // RTA is a road-transport accident
    public enum Type {
        RED_LIGHT, DRUNK, PEDESTRIAN, RTA, SPEED_LIMIT;

//        public static Type getByValue(String value) {
//            switch (value.toLowerCase()) {
//                case "red_light":
//                    return RED_LIGHT;
//                case "drunk":
//                    return DRUNK;
//                case "pedestrian":
//                    return PEDESTRIAN;
//                case "speed_limit":
//                    return SPEED_LIMIT;
//                case "rta":
//                    return RTA;
//                default:
//                    throw new IllegalArgumentException("No such Licence.Category \'" + value + "\'");
//            }
//        }
    }

    @Override
    public String toString() {
        return "Offence{" +
                "date: " + date +
                ", type: " + type +
                '}';
    }
}
