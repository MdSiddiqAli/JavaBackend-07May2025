package com.handson.usecase.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "emp_id")
	private Integer empId;
	
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy = "employee")
    private Organization organization;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_asset", 
      joinColumns = 
        { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "asset_id", referencedColumnName = "id") })
	private Set<Asset> assets;
	
	public Employee() {
		
	}
	
	public Employee(Integer empId, String name, Organization organization, Set<Asset> assets) {
		super();
		this.empId = empId;
		this.name = name;
		this.organization = organization;
		this.assets = assets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public Set<Asset> getAssets() {
		return assets;
	}

	public void setAssets(Set<Asset> assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", name=" + name + ", organization=" + organization
				+ ", assets=" + assets + "]";
	}

}
