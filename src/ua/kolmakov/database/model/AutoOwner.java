package ua.kolmakov.database.model;

import java.util.List;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

public class AutoOwner {
    private int id;
    private Address address;
    private Passport passport;
    private Licence licence;
    private List<Vehicle> vehicles;
    private List<Offence> offences;

    public AutoOwner(int id, Address address, Passport passport, Licence licence, List<Vehicle> vehicles, List<Offence> offences) {
        this.id = id;
        this.address = address;
        this.passport = passport;
        this.licence = licence;
        this.vehicles = vehicles;
        this.offences = offences;

    }

    public int getId() {
        return id;
    }

    public Passport getPassport() {
        return passport;
    }

    public Licence getLicence() {
        return licence;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Offence> getOffences() {
        return offences;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addOffence(Offence offence) {
        offences.add(offence);
    }

    @Override
    public String toString() {
        return "\n   AUTO_OWNER{" +
                "\npassport=" + passport +
                "\nlicence=" + licence +
                "\nvehicles=" + vehicles +
                "\noffences=" + offences +
                "}\n";
    }
}
