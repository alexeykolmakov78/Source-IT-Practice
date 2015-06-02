package ua.kolmakov.logistic;

import ua.kolmakov.logistic.api.service.SenderService;
import ua.kolmakov.logistic.impl.service.LogisticSenderService;

import java.util.Arrays;

/**
 * Created by Kolmakov Alexey on 31.05.2015.
 */
public class StartLogistic {
    public static void main(String[] args) {
        SenderService service = new LogisticSenderService();
        System.out.println(Arrays.toString(service.getAllOffices()));
        System.out.println("----------------------------------------");

    }
}
