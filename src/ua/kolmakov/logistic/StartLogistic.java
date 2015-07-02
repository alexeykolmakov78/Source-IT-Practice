package ua.kolmakov.logistic;

import ua.kolmakov.logistic.api.model.person.Address;
import ua.kolmakov.logistic.api.model.person.FullName;
import ua.kolmakov.logistic.api.model.person.Person;
import ua.kolmakov.logistic.api.model.post.Package;
import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.Transit;
import ua.kolmakov.logistic.api.service.SenderService;
import ua.kolmakov.logistic.impl.model.person.PersonFullName;
import ua.kolmakov.logistic.impl.model.person.PostAddress;
import ua.kolmakov.logistic.impl.model.person.Sender;
import ua.kolmakov.logistic.impl.service.LogisticSenderService;
import ua.kolmakov.logistic.impl.service.Storage;

import java.io.DataInputStream;
import java.io.IOException;

public class StartLogistic {
    public static void main(String[] args) {

        SenderService service = new LogisticSenderService();

        System.out.println("All Post Offices: " + service.getAllOffices());
        System.out.println();
        Address senderAddress = new PostAddress(15396, "France", "Paris", "Mulen Rouge");

//      Address senderAddress = new PostAddress(12345, "Ukraine", "Kharkov", "Ivanova");
        FullName senderName = new PersonFullName("Taras", "Petrovich", "Bulba");
        Person sender = new Sender(senderAddress, senderName);

        Address receiverAddress = new PostAddress(25896, "UAE", "Dubai", "Burj Halifa");
//      Address receiverAddress = new PostAddress(45456, "Russia", "Novgorod", "Lenina");
//      Address receiverAddress = new PostAddress(15396, "France", "Paris", "Mulen Rouge");
        FullName receiverName = new PersonFullName("Sofy", "Fransua", "Loren");
        Package.Type packageType = Package.Type.T_25;
        int packageWeight = 20;

        Package parcel = sender.createPackage(receiverAddress, receiverName, packageType, packageWeight);

        PostOffice senderOffice = Storage.getInstance().getPostOfficeByAddress(senderAddress);
        PostOffice destinationOffice = Storage.getInstance().getPostOfficeByAddress(receiverAddress);

        Transit[] transitVariants = service.calculatePossibleTransits(parcel, senderOffice, destinationOffice);


        // здесь вставить выбор варианта транзита

//        Transit transit = transitVariants[0];
        Transit transit = selectTransit(transitVariants);

        parcel.setTransit(transit);
        System.out.println("Miles to destination (at the start point): " + service.getMilesToDestination(parcel));
        System.out.println();
        System.out.println("Current position (start): " + service.getPackageCurrentPosition(parcel));
        service.sendPackage(parcel, transit);
        System.out.println();
        System.out.println("Transit cost: " + parcel.getTransit().getPrice());
        System.out.println();
        System.out.println("Current position (destination): " + service.getPackageCurrentPosition(parcel));
        System.out.println();
        System.out.println("All transit post offices (Stamps): \n" + parcel.getStamps());

        System.out.println("Miles to destination (at the destination point): " + service.getMilesToDestination(parcel));

    }

    private static Transit selectTransit(Transit[] transitVariants) {
        System.out.println("\n----------SELECT TRANSIT----------");
        System.out.println("Press 1 to select the cheapest transit\n" +
                "Press 2 to select the shortest transit\n");
        int variant = inputNumber() - 1;
        return transitVariants[variant];
    }

    private static int inputNumber() {
        DataInputStream is = new DataInputStream(System.in);
        int number;
        try {
            number = is.read();
            if (number == '1') {
                System.out.println("The cheapest transit selected");
                return 1;
            } else if (number == '2') {
                System.out.println("The shortest transit selected");
                return 2;
            }
        } catch (IOException e) {
            System.out.println("ERROR ");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println("ERROR ");
            }
        }
        System.out.print("ERROR ");
        System.out.println("The cheapest transit selected");
        return 1;
    }
}
