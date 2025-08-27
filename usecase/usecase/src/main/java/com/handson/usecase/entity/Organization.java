package com.handson.usecase.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "org_emp", 
      joinColumns = 
        { @JoinColumn(name = "org_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "employee_id", referencedColumnName = "id") })
    private Employee employee;

	public Organization() {
		
	}

	public Organization(String name, Employee employee) {
		super();
		this.name = name;
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}

}
