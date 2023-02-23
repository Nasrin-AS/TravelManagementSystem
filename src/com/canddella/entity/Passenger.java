package com.canddella.entity;

public class Passenger {
	private int passengerId;
	private String passengerName;
	private String passengerAddress;
	private String passengerPhoneNumber;
	private String passengerMailId;
	
	public Passenger() {
		super();
	}
	public Passenger(int passengerId, String passengerName, String passengerAddress, String passengerPhoneNumber,
			String passengerMailId) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAddress = passengerAddress;
		this.passengerPhoneNumber = passengerPhoneNumber;
		this.passengerMailId = passengerMailId;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	public String getPassengerPhoneNumber() {
		return passengerPhoneNumber;
	}
	public void setPassengerPhoneNumber(String passengerPhoneNumber) {
		this.passengerPhoneNumber = passengerPhoneNumber;
	}
	public String getPassengerMailId() {
		return passengerMailId;
	}
	public void setPassengerMailId(String passengerMailId) {
		this.passengerMailId = passengerMailId;
	}
	
}
