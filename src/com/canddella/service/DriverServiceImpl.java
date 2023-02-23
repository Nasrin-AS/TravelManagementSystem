package com.canddella.service;

import java.util.List;

import com.canddella.dao.DriverDAOImpl;
import com.canddella.entity.Driver;

public class DriverServiceImpl implements DriverService {

	@Override
	public List<Driver> findAll() {
		DriverDAOImpl driverDAOImpl = new DriverDAOImpl();
		List<Driver> driverList = driverDAOImpl.findAll();
		return driverList;

	}

	@Override
	public void save(Driver driver) {
		DriverDAOImpl driverDAOImpl = new DriverDAOImpl();
		int row = driverDAOImpl.save(driver);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Driver driver) {
		DriverDAOImpl driverDAOImpl = new DriverDAOImpl();
		int row = driverDAOImpl.update(driver);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public int delete(Driver driver) {
		DriverDAOImpl driverDAOImpl = new DriverDAOImpl();
		int row = driverDAOImpl.delete(driver);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public Driver driverid(int id) {
			DriverDAOImpl driverDAOImpl = new DriverDAOImpl();
			Driver driver = driverDAOImpl.driverid(id);
			
			return driver;
		}

}
