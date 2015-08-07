package ua.kolmakov.multithreaded_storage;

import ua.kolmakov.multithreaded_storage.api.Requests;
import ua.kolmakov.multithreaded_storage.entities.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Kolmakov Alexey on 02.07.2015.
 * <p>
 * StorageManager
 * This class get connections with Clients and the MultiThreadAutoDataStorage:
 * <p>
 * StorageManager starts in the own thread
 */
public class StorageManager implements Runnable, Requests {
    public static MultiThreadAutoDataStorage storage = MultiThreadAutoDataStorage.getInstance();

    @Override
    public void run() {
        synchronized (storage) {
            Initializer.initAutoOwners();
            Initializer.initVehicles();
            while (true) {
                try {
                    System.out.println("STORAGE_MANAGER: is ready");
                    storage.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return storage.getById("vehicles");
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerLastName(String lastName) {
        Set<Vehicle> vehicles = storage.getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getOwnerLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoOwner> getAutoOwnersByPartOfRegistrationNumber(String numberPart) {
        Set<Vehicle> vehicles = storage.getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getRegistrationNumber().contains(numberPart))
                .map(v-> getByLastName(v.getOwnerLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getNotServicedInTimeVehicles(int yearsBetweenServices) {
        Set<Vehicle> vehicles = storage.getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getLastServiceDate().getYear() + yearsBetweenServices < new Date().getYear())//max 3 years to next service
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoOwner> getDrinkingAutoOwners() {
        Set<AutoOwner> autoOwners = storage.getById("autoOwners");
        List<AutoOwner> drunken = new ArrayList<>();
        for (AutoOwner a : autoOwners) {
            drunken.addAll(
                    a.getOffences().stream()
                            .filter(o -> o.getType() == Offence.Type.DRUNK)
                            .map(o -> a)
                            .collect(Collectors.toList()));
        }
        return drunken;
    }

    @Override
    public List<Vehicle> getVehiclesRTAParticipants() {
        List<Vehicle> vehicles = storage.getById("vehicles");
        return vehicles.stream()
                .filter(v -> v.getRtaList().size() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "MultiThreadAutoDataStorage{" +
                "drivers:" + storage.getById("drivers") +
                "\nvehicles:" + storage.getById("vehicles") +
                '}';
    }

    private static class Initializer {
        private static void initAutoOwners() {
//Person
            String firstName, lastName, middleName;
            Date dateOfBirth;
            Passport passport;
            Licence licence;
//Passport
            String passportID;
            Date passportRegistrationDate;
            String passportRegisteredBy;
            PostAddress address;
//Licence
            String licenceID;
            Licence.Category category;
            Date licenceRegistrationDate;
            String licenceRegisteredBy;

// Preparing data for creating 10 autoOwners.
            List<String> firstNames = new ArrayList<>(Arrays.asList(new String[]{
                    "John", "John", "William", "Jack", "Andrew", "Robert", "Anthony", "Samantha", "Julia", "Helen"}));
            List<String> lastNames = new ArrayList<>(Arrays.asList(new String[]{
                    "Smith", "Wilson", "Brown", "Grady", "Roberts", "Jones", "Lee", "Stuart", "Postman", "Franny"}));
            List<String> middleNames = new ArrayList<>(Arrays.asList(new String[]{
                    "Steven", "Martin", "Jan", "John", "Robin", "Bob", "Mathew", "Patric", "Smith", "Ted"}));

            List<PostAddress> addresses = new ArrayList<>();
            addresses.add(new PostAddress(34634, "USA", "New York", "10th st"));
            addresses.add(new PostAddress(25482, "USA", "San Francisco", "Evance ave"));
            addresses.add(new PostAddress(78682, "USA", "Los Angeles", "Beach ave"));
            addresses.add(new PostAddress(53734, "USA", "New York", "Grand st"));
            addresses.add(new PostAddress(27782, "USA", "New York", "56th st"));
            addresses.add(new PostAddress(27852, "USA", "San Francisco", "Paris st"));
            addresses.add(new PostAddress(56834, "USA", "San Francisco", "Mission st"));
            addresses.add(new PostAddress(25482, "USA", "Los Angeles", "S Broadway"));
            addresses.add(new PostAddress(36985, "USA", "Los Angeles", "50 street"));
            addresses.add(new PostAddress(88596, "USA", "Las Vegas", "E Vegas Valley dr"));
            addresses.add(new PostAddress(58624, "USA", "Las Vegas", "E Sahara ave"));

            List<Date> datesOfBirth = new ArrayList<>();
            datesOfBirth.add(new Date(78, 1, 9));
            datesOfBirth.add(new Date(65, 2, 4));
            datesOfBirth.add(new Date(89, 9, 25));
            datesOfBirth.add(new Date(76, 11, 13));
            datesOfBirth.add(new Date(97, 8, 17));
            datesOfBirth.add(new Date(88, 4, 21));
            datesOfBirth.add(new Date(86, 4, 9));
            datesOfBirth.add(new Date(77, 5, 4));
            datesOfBirth.add(new Date(94, 8, 7));
            datesOfBirth.add(new Date(92, 8, 28));

            List<String> passportIDs = (Arrays.asList("qw123456", "rt869656", "gy870568", "ck5490884", "nd936759",
                    "er342652", "gh192023", "br372838", "pu968585", "bl795865"));

            // The list of passport registration dates and the list of licence registration dates
            // are based on the list of the dates of birth.
            List<Date> passportRegistrationDates = new ArrayList<>();
            List<Date> licenceRegistrationDates = new ArrayList<>();
            for (Iterator<Date> i = datesOfBirth.iterator(); i.hasNext(); ) {
                Date date = i.next();
                Date passRegDate = new Date(date.getDate());
                passRegDate.setYear(date.getYear() + 16);
                passportRegistrationDates.add(passRegDate);
                Date licenceRegDate = new Date(date.getDate());
                licenceRegDate.setYear(date.getYear() + 18);
                licenceRegistrationDates.add(licenceRegDate);
            }
            //Passports are registered in the police departments. ()
            List<String> policeDepartments = (Arrays.asList("Police Department #42", "Police Department #154",
                    "Police Department #4", "Police Department #72", "Police Department #44",
                    "Police Department #13", "Police Department #58", "Police Department #49",
                    "Police Department #13", "Police Department #55"));

            //List of licence departments is based on the list of police departments.
            List<String> licenceDepartments = policeDepartments
                    .stream()
                    .map(each -> each.replace("Police", "Licence"))
                    .collect(Collectors.toList());

            //List of licence IDs is based on the list of passport IDs.
            List<String> licenceIDs = passportIDs
                    .stream()
                    .map(id -> "l".concat(id))
                    .collect(Collectors.toList());

            List<Licence.Category> licenceCategories = new ArrayList<>(Arrays.asList(new Licence.Category[]{
                    Licence.Category.B, Licence.Category.C, Licence.Category.B, Licence.Category.D, Licence.Category.B,
                    Licence.Category.B, Licence.Category.B, Licence.Category.A, Licence.Category.B, Licence.Category.C,}));

            // create 10 drives
            List<AutoOwner> autoOwners = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                firstName = firstNames.get(i);
                lastName = lastNames.get(i);
                middleName = middleNames.get(i);
                address = addresses.get(i);

                dateOfBirth = datesOfBirth.get(i);
                passportID = passportIDs.get(i);
                passportRegistrationDate = passportRegistrationDates.get(i);
                passportRegisteredBy = policeDepartments.get(i);
                passport = new Passport(firstName, lastName, middleName, dateOfBirth, passportID,
                        passportRegistrationDate, passportRegisteredBy, address);

                licenceID = licenceIDs.get(i);
                category = licenceCategories.get(i);
                licenceRegistrationDate = licenceRegistrationDates.get(i);
                licenceRegisteredBy = licenceDepartments.get(i);
                licence = new Licence(licenceID, category, licenceRegistrationDate, licenceRegisteredBy, address);

                AutoOwner autoOwner = AutoOwner.newBuilder()
                        .setPassport(passport)
                        .setLicence(licence)
                        .build();
                autoOwners.add(autoOwner);


            }
            storage.putToStorage("autoOwners", autoOwners);
            AutoOwner drunkard = getByLastName("Brown");
            drunkard.addOffence(new Offence(randomDate(2013, 2014), Offence.Type.DRUNK));
        }

        private static void initVehicles() {
            // preparing data for 14 vehicles
            List<String> brands = new ArrayList<>(Arrays.asList(new String[]{
                    "Toyota", "BMW", "Mercedes", "Audi", "Toyota", "Toyota", "Lexus",
                    "Ford", "BMW", "Mercedes", "Audi", "Toyota", "Toyota", "Lexus"}));
            List<String> models = new ArrayList<>(Arrays.asList(new String[]{
                    "Camry", "X6", "GL350", "R8", "Land Cruiser 200", "Rav 4", "GS 350",
                    "Cuga", "650", "SLK 700", "TT", "Corolla", "Corolla", "LS 450"}));
            List<String> registrationNumbers = new ArrayList<>(Arrays.asList(new String[]{
                    "as78098", "000001", "SHURA", "888888", "aa2000", "fr478596", "ii0008",
                    "u589658", "456789", "SLK 700", "444444", "gt896422", "ws789654", "oo9999"}));

            List<Date> productionDates = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                productionDates.add(randomDate(2004, 2012));
            }

            // date of the last technical service
            List<Date> lastServiceDates = new ArrayList<>();
            for (int i = 0; i < brands.size(); i++) {
                lastServiceDates.add(randomDate(2012, 2014));
            }

            // make some accidents...
            List<RTA> rtaList = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                rtaList.add(null);
            }
            rtaList.set(2, new RTA(randomDate(2004, 2014), 88));
            rtaList.set(6, new RTA(randomDate(2004, 2014), 88));
            rtaList.set(7, new RTA(randomDate(2004, 2014), 10000));
            rtaList.set(10, new RTA(randomDate(2004, 2014), 20000));
            rtaList.set(12, new RTA(randomDate(2004, 2014), 555555));
            //
            List<String> ownersLastNames = new ArrayList<>(Arrays.asList(new String[]{
                    "Smith", "Smith", "Wilson", "Brown", "Grady", "Roberts", "Jones",
                    "Lee", "Stuart", "Postman", "Franny", "Smith", "Jones", "Roberts"}));

            //create 14 Vehicles..
            Set<Vehicle> vehicles = new HashSet<>();
            for (int i = 0; i < 14; i++) {
                Vehicle vehicle = Vehicle.newBuilder()
                        .setBrand(brands.get(i))
                        .setModel(models.get(i))
                        .setOwnerLastName(ownersLastNames.get(i))
                        .setProductionDate(productionDates.get(i))
                        .setLastServiceDate(lastServiceDates.get(i))
                        .setRegistrationNumber(registrationNumbers.get(i))
                        .build();

                if (rtaList.get(i) != null) {
                    vehicle.addRTA(rtaList.get(i));
                }

                vehicles.add(vehicle);

                //add all vehicles to the corresponding owners vehicles lists.
                ArrayList<AutoOwner> autoOwners = storage.getById("autoOwners");
                autoOwners.stream()
                        .filter(d -> d == getByLastName(vehicle.getOwnerLastName()))
                        .forEach(d -> d.addVehicle(vehicle));

                storage.putToStorage("vehicles", vehicles);
            }
        }

        private static Date randomDate(int fromYear, int toYear) {
            Random rnd = new Random();

            int year = rnd.nextInt(toYear - fromYear) + fromYear - 1900;
            int month = rnd.nextInt(11) + 1;
            int day = rnd.nextInt(27) + 1;
            return new Date(year, month, day);
        }

    }

    //можно реализовать этот метод в Storage или AutoOwner
    public static AutoOwner getByLastName(String lastName) {
        List<AutoOwner> autoOwners = storage.getById("autoOwners");
        return autoOwners.stream()
                .filter(o -> lastName.equals(o.getPassport().getLastName()))
                .findAny().get();
    }

}
