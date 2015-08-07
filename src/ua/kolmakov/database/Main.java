package ua.kolmakov.database;

import ua.kolmakov.database.util.H2Connector;
import ua.kolmakov.database.util.RequestMaker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Kolmakov Alexey on 16.07.2015.
 */
public class Main {
    public static void main(String[] args) {

        Connection conn = H2Connector.getConnection();
        RequestMaker rm = new RequestMaker();

        try {
            System.out.println("\n# ALL VEHICLES: #");
            System.out.println(rm.getAllVehicles());
            System.out.println("\n# AUTO-OWNERS BY PART OF REGISTRATION NUMBER (\"000\"): #");
            System.out.println(rm.getAutoOwnersByPartOfRegistrationNumber("000"));
            System.out.println("\n# VEHICLES BY AUTO-OWNERS LAST NAME (\"Smith\"): #");
            System.out.println(rm.getVehiclesByOwnerLastName("Smith"));
            System.out.println("\n# AUTO-OWNERS WHICH HAVE BEEN CAUGHT DRUNK: #");
            System.out.println(rm.getDrinkingAutoOwners());
            System.out.println("\n# VEHICLES WHICH HAVEN'T BEEN SERVICED IN TIME: #");
            System.out.println(rm.getNotServicedInTimeVehicles(3));
            System.out.println("\n# RTA (road-transport accident) PARTICIPANTS: #");
            System.out.println(rm.getVehiclesRTAParticipants());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
