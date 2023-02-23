package com.canddella.service;

import java.util.List;

import com.canddella.entity.Driver;

public interface DriverService {
	List<Driver> findAll();
	void save(Driver driver);
	int update(Driver driver);
	int delete(Driver driver);
	Driver driverid(int id);
}
