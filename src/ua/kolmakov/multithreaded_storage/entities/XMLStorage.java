package ua.kolmakov.multithreaded_storage.entities;

import ua.kolmakov.multithreaded_storage.api.Parser;
import ua.kolmakov.multithreaded_storage.api.Storage;
import ua.kolmakov.multithreaded_storage.parser.JaxbParser;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 07.07.2015.
 */
//        Задание: поднимаем задание №8 (Разработать программу, предназначенную для обработки данных ГАИ о владельцах автотранспорта
//        и зарегистрированных на них автомобилей.)
//        И реализовуем хранение всех данных в XML.
//        Необходимо учесть добавление и удаление обьектов(узлов) из XML документа.
@XmlRootElement(name = "storage")
public class XMLStorage implements Storage {

    private static File xmlStorage = new File("src\\ua\\kolmakov\\multithreaded_storage\\resources\\storage.xml");

    private static XMLStorage instance = new XMLStorage();

    public static XMLStorage getInstance() {
        return (instance == null) ? new XMLStorage() : instance;
    }

    private Parser parser;
    private List<AutoOwner> autoOwners;
    private List<Vehicle> vehicles;

    private XMLStorage() {
        try {
            xmlStorage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        parser = new JaxbParser();
        autoOwners = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    @XmlElementWrapper(name = "autoowners")
    @XmlElement(name = "autoowner")
    public void setAutoOwners(List<AutoOwner> autoOwners) {
        this.autoOwners = autoOwners;
    }

    @XmlElementWrapper(name = "vehicles")
    @XmlElement(name = "vehicle")
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<AutoOwner> getAutoOwners() {
        return autoOwners;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    //****************************************************************
    @Override
    public void putToStorage(Object key, Object value) {
        try {
            parser.saveObject(xmlStorage, value);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getById(Object key) throws ClassCastException {
        try {
            return (T) parser.getObject(xmlStorage, getClass());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "XMLStorage{" +
                "autoOwners=" + autoOwners +
                ", vehicles=" + vehicles +
                '}';
    }
}
