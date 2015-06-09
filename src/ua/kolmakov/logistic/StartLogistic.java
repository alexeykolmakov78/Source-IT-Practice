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

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class StartLogistic {
    public static void main(String[] args) {

        SenderService service = new LogisticSenderService();

        System.out.println("All Post Offices: " + service.getAllOffices());
        System.out.println();

        Address senderAddress = new PostAddress(12345, "Ukraine", "Kharkov", "Ivanova");
        FullName senderName = new PersonFullName("Taras", "Petrovich", "Bulba");
        Person sender = new Sender(senderAddress, senderName);
        Address receiverAddress = new PostAddress(15396, "France", "Paris", "Mulen Rouge");
        FullName receiverName = new PersonFullName("Sofy", "Fransua", "Loren");
        Package.Type packageType = Package.Type.T_25;
        int packageWeight = 20;

        Package parcel = sender.createPackage(receiverAddress, receiverName, packageType, packageWeight);

        PostOffice senderOffice = Storage.getInstance().getPostOfficeByAddress(senderAddress);
        PostOffice destinationOffice = Storage.getInstance().getPostOfficeByAddress(receiverAddress);

        Transit[] transitVariants = service.calculatePossibleTransits(parcel, senderOffice, destinationOffice);

        // здесь вставить выбор варианта транзита
        Transit transit = transitVariants[0];
        parcel.setTransit(transit);
        System.out.println("Miles to destination before sending: " + service.getMilesToDestination(parcel));
        System.out.println();
        System.out.println("Current position (start): " + service.getPackageCurrentPosition(parcel));
        service.sendPackage(parcel, transit);
        System.out.println();
        System.out.println("Transit cost: " + parcel.getTransit().getPrice());
        System.out.println();
        System.out.println("Current position (destination): " + service.getPackageCurrentPosition(parcel));
        System.out.println();
        System.out.println("All transit post offices (Stamps): \n" + parcel.getStamps());

        System.out.println("Miles to destination after sending: " + service.getMilesToDestination(parcel));


    }

}
