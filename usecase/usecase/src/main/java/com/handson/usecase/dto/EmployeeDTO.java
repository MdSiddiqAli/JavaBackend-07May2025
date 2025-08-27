package com.handson.usecase.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class EmployeeDTO {
	
	private Integer empId;
	private String name;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<AssetDTO> assets = new HashSet<>();
	
	public EmployeeDTO() {
		
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<AssetDTO> getAssets() {
		return assets;
	}
	public void setAssets(Set<AssetDTO> assets) {
		this.assets = assets;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", name=" + name + ", assets=" + assets + "]";
	}

}
