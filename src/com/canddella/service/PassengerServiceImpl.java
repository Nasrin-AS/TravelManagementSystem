package com.canddella.service;

import java.util.List;

import com.canddella.dao.PassengerDAOImpl;
import com.canddella.entity.Passenger;

public class PassengerServiceImpl implements PassengerService {

	@Override
	public List<Passenger> findAll() {
		PassengerDAOImpl passengerDAOImpl = new PassengerDAOImpl();
		List<Passenger> passengerList = passengerDAOImpl.findAll();
		return passengerList;
	}

	@Override
	public void save(Passenger passenger) {
		PassengerDAOImpl passengerDAOImpl = new PassengerDAOImpl();
		int row = passengerDAOImpl.save(passenger);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}
	@Override
	public int update(Passenger passenger) {
		PassengerDAOImpl passengerDAOImpl = new PassengerDAOImpl();
		int row = passengerDAOImpl.update(passenger);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}
	@Override
	public int delete(Passenger passenger) {
		PassengerDAOImpl passengerDAOImpl = new PassengerDAOImpl();
		int row = passengerDAOImpl.delete(passenger);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	}
	@Override
	public Passenger passengerid(int id) {
		PassengerDAOImpl passengerDAOImpl = new PassengerDAOImpl();
		Passenger passenger = passengerDAOImpl.passengerid(id);
		
		return passenger;
	}
}
