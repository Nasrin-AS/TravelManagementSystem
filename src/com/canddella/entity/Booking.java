package com.canddella.entity;

public class Booking {
	private int bookingId; 
	private Passenger passenger;
	private Bus bus;
	private BusRoute busRoute;
	private String bookingDate;
	
	public Booking() {
		super();
	}
	public Booking(int bookingId,Passenger passenger,Bus bus, BusRoute busRoute, String bookingDate) {
		super();
		this.bookingId = bookingId;
		this.passenger = passenger;
		this.bus = bus;
		this.busRoute = busRoute;
		this.bookingDate = bookingDate;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public BusRoute getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

}
