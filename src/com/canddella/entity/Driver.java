package com.canddella.entity;

public class Driver {
	private int driverId;
	private String driverName;
	private String driverPlace;
	private String driverPhoneNumber;
	
	public Driver() {
		super();
	}
	public Driver(int driverId, String driverName, String driverPlace, String driverPhoneNumber) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverPlace = driverPlace;
		this.driverPhoneNumber = driverPhoneNumber;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPlace() {
		return driverPlace;
	}
	public void setDriverPlace(String driverPlace) {
		this.driverPlace = driverPlace;
	}
	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}
	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}
	
	
}
