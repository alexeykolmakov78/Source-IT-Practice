package ua.kolmakov.database.util;

import ua.kolmakov.database.api.Requests;
import ua.kolmakov.database.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 * <p>
 * RequestMaker
 */
public class RequestMaker implements Requests {

    private static Connection conn = H2Connector.getConnection();

    @Override
    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM  VEHICLE;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            Vehicle vehicle = Vehicle.newBuilder()
                    .setId(id)
                    .setBrand(rs.getString("brand"))
                    .setModel(rs.getString("model"))
                    .setRegistrationNumber(rs.getString("reg_number"))
                    .setOwner(getOwnerById(rs.getInt("autoowner_id")))
                    .setProductionDate(rs.getDate("production_date"))
                    .setLastServiceDate(rs.getDate("last_service_date"))
                    .setRtaList(getRtaListByVehicleId(id))
                    .build();
            vehicles.add(vehicle);
        }
        rs.close();
        stmt.close();
        return vehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerLastName(String lastName) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT V.* FROM  VEHICLE V, " +
                "AUTOOWNER A, " +
                "PASSPORT P " +
                "WHERE V.AUTOOWNER_ID = A.ID " +
                "AND A.PASSPORT_ID = P.ID " +
                "AND P.LAST_NAME = \'" + lastName + "\'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            Vehicle vehicle = Vehicle.newBuilder()
                    .setId(id)
                    .setBrand(rs.getString("brand"))
                    .setModel(rs.getString("model"))
                    .setRegistrationNumber(rs.getString("reg_number"))
                    .setOwner(getOwnerById(rs.getInt("autoowner_id")))
                    .setProductionDate(rs.getDate("production_date"))
                    .setLastServiceDate(rs.getDate("last_service_date"))
                    .setRtaList(getRtaListByVehicleId(id))
                    .build();
            vehicles.add(vehicle);
        }
        rs.close();
        stmt.close();
        return vehicles;
    }

    @Override
    public List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart) throws SQLException {
        List<AutoOwner> autoOwners = new ArrayList<>();
        String pattern = "%" + numberPart + "%";
        String sql = "SELECT DISTINCT \n" +
                "  AO.ID,\n" +
                "  A.*,\n" +
                "  P.*,\n" +
                "  L.*\n" +
                "FROM AUTOOWNER AO\n" +
                "  JOIN ADDRESS A ON AO.ADDRESS_ID = A.ID\n" +
                "  JOIN PASSPORT P ON AO.PASSPORT_ID = P.ID\n" +
                "  JOIN LICENCE L ON AO.LICENCE_ID = L.ID\n" +
                "  JOIN VEHICLE V ON AO.ID = V.AUTOOWNER_ID\n" +
                "WHERE V.REG_NUMBER LIKE ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, pattern);
        ResultSet rs = ps.executeQuery();
        AutoOwner autoOwner;
        Address address;
        Passport passport;
        Licence licence;
        int id;
        while (rs.next()) {
            id = rs.getInt(1);
            address = new Address(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
            passport = new Passport(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11),
                    rs.getString(12), rs.getDate(13), rs.getString(14));
            licence = new Licence(rs.getInt(15), rs.getString(17), Licence.Category.valueOf(rs.getString(19)),
                    rs.getDate(16), rs.getString(18));
            autoOwner = new AutoOwner(
                    rs.getInt(1),
                    address,
                    passport,
                    licence,
                    getVehiclesByOwnerId(id),
                    getOffencesByOwnerId(id)
            );
            autoOwners.add(autoOwner);
        }
        rs.close();
        ps.close();
        return autoOwners;
    }

    @Override
    public List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        LocalDate now = LocalDate.now();
        Date etalon = Date.valueOf(now.getYear() - yearsBetweenServices + "-" + now.getMonth().getValue() + "-" + now.getDayOfMonth());

        String sql = "SELECT * FROM VEHICLE WHERE LAST_SERVICE_DATE < ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, etalon);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            Vehicle vehicle = Vehicle.newBuilder()
                    .setId(id)
                    .setBrand(rs.getString("brand"))
                    .setModel(rs.getString("model"))
                    .setRegistrationNumber(rs.getString("reg_number"))
                    .setOwner(getOwnerById(rs.getInt("autoowner_id")))
                    .setProductionDate(rs.getDate("production_date"))
                    .setLastServiceDate(rs.getDate("last_service_date"))
                    .setRtaList(getRtaListByVehicleId(id))
                    .build();
            vehicles.add(vehicle);
        }
        rs.close();
        ps.close();
        return vehicles;
    }

    @Override
    public List<AutoOwner> getDrinkingAutoOwners() throws SQLException {
        List<AutoOwner> autoOwners = new ArrayList<>();
        String type = "DRUNK";
        String sql = "SELECT\n" +
                "  AO.ID,\n" +
                "  A.*,\n" +
                "  P.*,\n" +
                "  L.*\n" +
                "FROM AUTOOWNER AO\n" +
                "  JOIN ADDRESS A ON AO.ADDRESS_ID = A.ID\n" +
                "  JOIN PASSPORT P ON AO.PASSPORT_ID = P.ID\n" +
                "  JOIN LICENCE L ON AO.LICENCE_ID = L.ID\n" +
                "  JOIN OFFENCE F ON AO.ID = F.AUTOOWNER_ID\n" +
                "WHERE F.TYPE = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, type);
        ResultSet rs = ps.executeQuery();
        AutoOwner autoOwner = null;
        Address address;
        Passport passport;
        Licence licence;
        int id;
        while (rs.next()) {
            id = rs.getInt(1);
            address = new Address(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
            passport = new Passport(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11),
                    rs.getString(12), rs.getDate(13), rs.getString(14));
            licence = new Licence(rs.getInt(15), rs.getString(17), Licence.Category.valueOf(rs.getString(19)),
                    rs.getDate(16), rs.getString(18));
            autoOwner = new AutoOwner(
                    rs.getInt(1),
                    address,
                    passport,
                    licence,
                    getVehiclesByOwnerId(id),
                    getOffencesByOwnerId(id)
            );
            autoOwners.add(autoOwner);
        }
        rs.close();
        ps.close();
        return autoOwners;
    }

    @Override
    public List<Vehicle> getVehiclesRTAParticipants() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT DISTINCT V.* FROM VEHICLE V, " +
                "RTA R " +
                "WHERE R.VEHICLE_ID = V.ID";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            Vehicle vehicle = Vehicle.newBuilder()
                    .setId(id)
                    .setBrand(rs.getString("brand"))
                    .setModel(rs.getString("model"))
                    .setRegistrationNumber(rs.getString("reg_number"))
                    .setOwner(getOwnerById(rs.getInt("autoowner_id")))
                    .setProductionDate(rs.getDate("production_date"))
                    .setLastServiceDate(rs.getDate("last_service_date"))
                    .setRtaList(getRtaListByVehicleId(id))
                    .build();
            vehicles.add(vehicle);
        }
        rs.close();
        stmt.close();
        return vehicles;
    }

    //*************************************************************************************
    private List<RTA> getRtaListByVehicleId(int id) throws SQLException {
        List<RTA> rtaList = new ArrayList<>();
        String sql = "SELECT * FROM  RTA WHERE VEHICLE_ID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            RTA rta = new RTA(
                    rs.getInt("id"),
                    rs.getDate("date"),
                    rs.getInt("code")
            );
            rtaList.add(rta);
        }
        rs.close();
        ps.close();
        return rtaList;
    }

    private AutoOwner getOwnerById(int id) throws SQLException {
        String sql = "SELECT\n" +
                "  AO.ID,\n" +
                "  A.*,\n" +
                "  P.*,\n" +
                "  L.*\n" +
                "FROM AUTOOWNER AO\n" +
                "  JOIN ADDRESS A ON AO.ADDRESS_ID = A.ID\n" +
                "  JOIN PASSPORT P ON AO.PASSPORT_ID = P.ID\n" +
                "  JOIN LICENCE L ON AO.LICENCE_ID = L.ID\n" +
                "WHERE AO.ID = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        AutoOwner autoOwner;
        Address address;
        Passport passport;
        Licence licence;

        rs.next();
        address = new Address(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
        passport = new Passport(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11),
                rs.getString(12), rs.getDate(13), rs.getString(14));
        licence = new Licence(rs.getInt(15), rs.getString(17), Licence.Category.valueOf(rs.getString(19)),
                rs.getDate(16), rs.getString(18));
        autoOwner = new AutoOwner(
                rs.getInt(1),
                address,
                passport,
                licence,
                getVehiclesByOwnerId(id),
                getOffencesByOwnerId(id)
        );
        rs.close();
        ps.close();
        return autoOwner;
    }

    private List<Offence> getOffencesByOwnerId(int id) throws SQLException {
        List<Offence> offences = new ArrayList<>();
        String sql = "SELECT * FROM OFFENCE WHERE AUTOOWNER_ID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Offence offence = new Offence(
                    rs.getInt("id"),
                    rs.getDate("date"),
                    Offence.Type.valueOf(rs.getString("type"))
            );
            offences.add(offence);
        }
        rs.close();
        ps.close();
        return offences;
    }

    private List<Vehicle> getVehiclesByOwnerId(int ownerId) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM VEHICLE WHERE AUTOOWNER_ID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ownerId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int vehicleId = rs.getInt("id");
            Vehicle vehicle = Vehicle.newBuilder()
                    .setId(vehicleId)
                    .setModel(rs.getString("model"))
                    .setRegistrationNumber(rs.getString("reg_number"))
//if we setOwner here we'll have a cyclic reference and StackOverflowError!!!
//                    .setOwner(getOwnerById(rs.getInt("autoowner_id")))
                    .setProductionDate(rs.getDate("production_date"))
                    .setLastServiceDate(rs.getDate("last_service_date"))
                    .setRtaList(getRtaListByVehicleId(vehicleId))
                    .build();
            vehicles.add(vehicle);
        }
        rs.close();
        ps.close();
        return vehicles;
    }
}


















