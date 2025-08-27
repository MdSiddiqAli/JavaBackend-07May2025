package com.handson.usecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.usecase.service.XmlValidator;

@RestController
@RequestMapping("/api")
public class XmlValidationController {

    private final XmlValidator xmlValidator;

//    @Autowired
    public XmlValidationController(XmlValidator xmlValidator) {
        this.xmlValidator = xmlValidator;
    }

    @PostMapping(value = "/validate-xml", consumes = "application/xml")
    public ResponseEntity<String> validateXml(@RequestBody String xmlContent) {
        if (xmlValidator.validate(xmlContent)) {
            return ResponseEntity.ok("XML is valid against the XSD.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("XML is not valid against the XSD.");
        }
    }
}