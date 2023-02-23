package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Driver;
import com.canddella.entity.Passenger;

public interface DriverDAO {
	List<Driver> findAll();
	int save(Driver driver);
	int update(Driver driver);
	int delete(Driver driver);
	Driver driverid(int id);
}
