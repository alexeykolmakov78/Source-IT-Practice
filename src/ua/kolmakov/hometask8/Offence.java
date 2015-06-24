package ua.kolmakov.hometask8;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Offence {
    private Date date;
    private Type type;

    private enum Type {
        TYPE1("light"), TYPE2("medium"), TYPE3("hard"), TYPE4("accident"), TYPE5("accident with victims");
        private String description;

        Type() {
            this("No description");
        }

        Type(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

    }

}
