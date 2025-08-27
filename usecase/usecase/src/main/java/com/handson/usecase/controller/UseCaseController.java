package com.handson.usecase.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handson.usecase.dto.OrganizationDTO;
import com.handson.usecase.service.UseCaseService;

@RestController
@RequestMapping("/usecase")
public class UseCaseController {
	
	@Autowired
	UseCaseService useCaseService;
	
	@PostMapping(value="/create", consumes=MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<OrganizationDTO> save(@RequestBody OrganizationDTO organizationDTO) {

		return Optional.ofNullable(useCaseService.save(organizationDTO))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@GetMapping(value="/get/{orgName}", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<OrganizationDTO> getByOrgName(@PathVariable String orgName) {

		return Optional.ofNullable(useCaseService.getByOrgName(orgName))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<OrganizationDTO> update(@RequestBody OrganizationDTO organizationDTO) {

		return Optional.ofNullable(useCaseService.update(organizationDTO))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_MODIFIED));
	}
	
	@DeleteMapping(value="/delete", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<OrganizationDTO> deleteByOrgName(@RequestParam String orgName) {

		return Optional.ofNullable(useCaseService.deleteByOrgName(orgName))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
}
