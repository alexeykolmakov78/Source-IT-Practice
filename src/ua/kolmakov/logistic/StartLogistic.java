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

import java.util.Arrays;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class StartLogistic {
    public static void main(String[] args) {

        SenderService service = new LogisticSenderService();

        Address senderAddress = new PostAddress(12345, "Ukraine", "Kharkov", "Ivanova");
        FullName senderName = new PersonFullName("Taras", "Petrovich", "Bulba");
        Person sender = new Sender(senderAddress, senderName);

        Address receiverAddress = new PostAddress(15396, "France", "Paris", "Mulen Rouge");
        FullName receiverName = new PersonFullName("Sofy", "Fransua", "Loren");
        Package.Type packageType = Package.Type.T_25;

        int packageWeight = 20;

        Package parcel = sender.createPackage(receiverAddress, receiverName, packageType, packageWeight);

        PostOffice senderOffice = getOfficeByAddress(senderAddress, service);
        PostOffice destinationOffice = getOfficeByAddress(receiverAddress, service);

        Transit[] transitVariants = service.calculatePossibleTransits(parcel, senderOffice, destinationOffice);
        // здесь вставить выбор варианта транзита
        Transit transit = transitVariants[0];

        service.sendPackage(parcel, transit);

    }

    private static PostOffice getOfficeByAddress(Address address, SenderService service) {
        PostOffice[] allOffices = service.getAllOffices();
        for (PostOffice each : allOffices) {
            if (each.getAddress() == address) {
                return each;
            }
        }

        return null;
    }


}
