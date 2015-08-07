package ua.kolmakov.multithreaded_storage.parser;

import ua.kolmakov.multithreaded_storage.api.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Kolmakov Alexey on 07.07.2015.
 */

public class JaxbParser implements Parser {
    @Override
    public Object getObject(File f, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(f);
        return object;
    }

    @Override
    public void saveObject(File f, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o,f);
    }
}
