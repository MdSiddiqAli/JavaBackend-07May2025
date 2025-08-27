package com.handson.usecase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "asset_number")
	private String assetNumber;
	
	@Column(name = "name")
	private String name;
	
	public Asset() {
		
	}
	
	public Asset(String assetNumber, String name) {
		super();
		this.assetNumber = assetNumber;
		this.name = name;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Asset [id=" + id + ", assetNumber=" + assetNumber + ", name=" + name  + "]";
	}

	
	
}
