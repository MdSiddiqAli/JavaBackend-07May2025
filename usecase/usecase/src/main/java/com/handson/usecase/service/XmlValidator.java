package com.handson.usecase.service;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

@Service
public class XmlValidator {

    private Schema schema;

    public XmlValidator() throws SAXException {
        // Load the XSD schema from the resources folder on application startup
        SchemaFactory factory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        this.schema = factory.newSchema(new StreamSource(getClass().getClassLoader().getResourceAsStream("bookstore.xsd")));
    }

    public boolean validate(String xmlContent) {
        try {
            Validator validator = schema.newValidator();
            Source source = new StreamSource(new StringReader(xmlContent));
            validator.validate(source);
            return true; // XML is valid
        } catch (IOException | SAXException e) {
//            System.err.println("XML Validation Failed: " + e.getMessage());
            e.printStackTrace();
            return false; // XML is invalid
        }
    }
}