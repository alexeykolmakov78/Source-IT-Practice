package ua.kolmakov.multithreaded_storage.api;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by Kolmakov Alexey on 07.07.2015.
 */
public interface Parser {

    Object getObject(File f, Class c) throws JAXBException;

    void saveObject(File f, Object o) throws JAXBException;
}
