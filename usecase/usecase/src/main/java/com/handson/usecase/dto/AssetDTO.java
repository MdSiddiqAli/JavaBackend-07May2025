package com.handson.usecase.dto;

public class AssetDTO {
	
	private String assetNumber;
	private String name;
	
	public AssetDTO() {
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
		return "AssetDTO [assetNumber=" + assetNumber + ", name=" + name + "]";
	}
	
}
