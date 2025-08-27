package com.handson.usecase.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.usecase.dto.XMLBookstoreDTO;
import com.handson.usecase.service.XmlConverter;

@RestController
@RequestMapping("/XMLOrPOJOViceVersa_covversion")
public class XmlConvertController {

    private final XmlConverter xmlConverter;

//    @Autowired
    public XmlConvertController(XmlConverter xmlConverter) {
        this.xmlConverter = xmlConverter;
    }

    @PostMapping(value = "/xml-pojo", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XMLBookstoreDTO> convertXmlToBookstore(@RequestBody String xmlContent) {
        try {
        	XMLBookstoreDTO bookstore = xmlConverter.convertXmlToPojo(xmlContent, XMLBookstoreDTO.class);
            return ResponseEntity.ok(bookstore);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    
    @PostMapping(value = "/pojo-xml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> convertBookstoreToXml(@RequestBody XMLBookstoreDTO bookstoreDTO) {
        try {
        	String bookstore = xmlConverter.convertPojoToXml(bookstoreDTO);
            return ResponseEntity.ok(bookstore);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}