package ua.kolmakov.multithreaded_storage;

import ua.kolmakov.multithreaded_storage.entities.AutoOwner;
import ua.kolmakov.multithreaded_storage.entities.Vehicle;
import ua.kolmakov.logistic.api.model.person.Address;

import java.util.List;

/**
 * Created by Kolmakov Alexey on 02.07.2015.
 */
public class Client implements Runnable {
//    private static StorageManager storageManager = new StorageManager();
    private static JaxbStorageManager storageManager = new JaxbStorageManager();
    private static long idCounter = 0;
    private String id;

    public Client() {
        this.id = "CLIENT_" + idCounter++;
    }

    @Override
    public void run() {
        System.out.println(id + " Requests the list of the vehicles which didn't have technical servicing more than 2 years");
        List<Vehicle> vehicles = null;
        synchronized (this) {
            while (vehicles == null) {
                try {
                    System.out.println(id + " is waiting for connection");
                    this.wait(1000);
                    vehicles = storageManager.getNotServicedInTimeVehicles(2);
                } catch (InterruptedException e) {
                    System.out.println(id + " is interrupted");
                    e.printStackTrace();
                }
            }

            System.out.println(id + " =======================================================================");
            System.out.println(id + " These AutoOwners didn't service his car more than 2 years");
            System.out.println(id + " List of auto owners and their addresses");
            for (Vehicle v : vehicles) {
//                Person o = StorageManager.getByLastName(v.getOwnerLastName());
                AutoOwner o = JaxbStorageManager.getByLastName(v.getOwnerLastName());
                Address a = o.getPassport().getAddress();
                System.out.println(id + " ----------------------------------------------------------------------");
                System.out.printf(id + " Owner: %s %s.\n", o.getPassport().getLastName(), o.getPassport().getFirstName());
                System.out.printf(id + " Address: %s %s %s.\n", a.getCountry(), a.getCity(), a.getStreet());
                System.out.printf(id + " Car: %s %s %s.\n", v.getBrand(), v.getModel(), v.getRegistrationNumber());
            }
        }
    }
}
