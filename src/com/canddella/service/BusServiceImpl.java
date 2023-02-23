package com.canddella.service;

import java.util.List;

import com.canddella.dao.BusDAOImpl;
import com.canddella.dao.BusRouteDAOImpl;
import com.canddella.dao.DriverDAOImpl;
import com.canddella.entity.Bus;
import com.canddella.entity.BusRoute;
import com.canddella.entity.Driver;

public class BusServiceImpl implements BusService {
	@Override
	public List<Bus> findall() {

		BusDAOImpl busDAOImpl = new BusDAOImpl();
		List<Bus> busList = busDAOImpl.findAll();
		return busList;
	}
	@Override
	public int save(Bus bus) {
		BusDAOImpl busDAOImpl = new BusDAOImpl();
		int row = busDAOImpl.save(bus);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	
		return 0;
	}

	@Override
	public int update(Bus bus) {
		BusDAOImpl busDAOImpl = new BusDAOImpl();
		int row = busDAOImpl.update(bus);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public int delete(Bus bus) {
		BusDAOImpl busDAOImpl = new BusDAOImpl();
		int row = busDAOImpl.delete(bus);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	}
	@Override
	public Bus busid(int id) {
			BusDAOImpl busDAOImpl = new BusDAOImpl();
			Bus bus = busDAOImpl.busid(id);
			
			return bus;
		}

}
