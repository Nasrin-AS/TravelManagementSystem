package com.canddella.entity;

public class Company {
	
	private int companyId;
	private String companyName;
	private String companyPlace;
	private String phoneNumber;
	
	public Company() {
		super();
	}
	public Company(int companyId, String companyName, String companyPlace, String phoneNumber) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyPlace = companyPlace;
		this.phoneNumber = phoneNumber;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyPlace() {
		return companyPlace;
	}
	public void setCompanyPlace(String companyPlace) {
		this.companyPlace = companyPlace;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
