package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Passenger;

public interface PassengerDAO {

	List<Passenger> findAll();
	int save(Passenger passenger);
	int update(Passenger passenger);
	int delete(Passenger passenger);
	Passenger passengerid(int id);
}
