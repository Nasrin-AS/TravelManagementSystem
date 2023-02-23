package com.canddella.service;

import java.util.List;

import com.canddella.entity.Passenger;

public interface PassengerService {

	List<Passenger> findAll();
	void save(Passenger passenger);
	int update(Passenger passenger);
	int delete(Passenger passenger);
	Passenger passengerid(int id);

}
