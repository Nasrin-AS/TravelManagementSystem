package com.canddella.entity;

public class BusRoute {
	private int routeId;
	private Bus bus;
	private String startingPoint;
	private String destination;
	private String startingTime;
	private String destinationTime;

	public BusRoute() {
		super();
	}

	public BusRoute(int routeId, Bus bus, String startingPoint, String destination, String startingTime,
			String destinationTime) {
		super();
		this.routeId = routeId;
		this.bus = bus;
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.startingTime = startingTime;
		this.destinationTime = destinationTime;
	
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

}
