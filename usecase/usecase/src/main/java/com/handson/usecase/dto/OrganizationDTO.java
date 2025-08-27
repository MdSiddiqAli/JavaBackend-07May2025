package com.handson.usecase.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "organization")
public class OrganizationDTO {
	
	@JacksonXmlProperty
    private String name;
	
	private EmployeeDTO employee;
	
	public OrganizationDTO() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "OrganizationDTO [name=" + name + ", employee=" + employee + "]";
	}

}
