package com.canddella.entity;

public class Bus {
	private int busId;
	private Driver driver; 
	private Owner owner;
	private String busName;
	public Bus() {
		super();
	}
	public Bus(int busId, Driver driver, Owner owner, String busName) {
		super();
		this.busId = busId;
		this.driver = driver;
		this.owner = owner;
		this.busName = busName;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
}
