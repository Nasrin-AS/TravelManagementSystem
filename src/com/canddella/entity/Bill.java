package com.canddella.entity;

public class Bill {
	private int billId;
	private Passenger passenger; 
	private Booking booking;
	private String paymentMode;
	private String paymentDate;
	private int amount;
	
	public Bill() {
		super();
	}

	public Bill(int billId, Passenger passenger, Booking booking, String paymentMode, String paymentDate, int amount) {
		super();
		this.billId = billId;
		this.passenger = passenger;
		this.booking = booking;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
