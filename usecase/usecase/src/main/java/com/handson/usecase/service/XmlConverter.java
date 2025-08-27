package com.handson.usecase.service;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

@Service
public class XmlConverter {

    public <T> T convertXmlToPojo(String xmlContent, Class<T> clazz) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xmlContent));
    }
    

    public <T> String convertPojoToXml(T pojo) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(pojo.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // For pretty-printing
        
        StringWriter sw = new StringWriter();
        marshaller.marshal(pojo, sw);
        
        return sw.toString();
    }
}