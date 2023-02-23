package com.canddella.service;

import java.util.List;
import com.canddella.dao.BusRouteDAOImpl;
import com.canddella.entity.BusRoute;


public class BusRouteServiceImpl implements BusRouteService {
	
	@Override
	public List<BusRoute> findall() {

		BusRouteDAOImpl busRouteDAOImpl = new BusRouteDAOImpl();
		List<BusRoute> busRouteList = busRouteDAOImpl.findAll();
		return busRouteList;

	}
	@Override
	public int save(BusRoute busRoute) {
		BusRouteDAOImpl busRouteDAOImpl = new BusRouteDAOImpl();
		int row = busRouteDAOImpl.save(busRoute);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	
		return 0;
	
	}
	
	@Override
	public int update(BusRoute busRoute) {
		BusRouteDAOImpl busRouteDAOImpl = new BusRouteDAOImpl();
		int row = busRouteDAOImpl.update(busRoute);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}
	@Override
	public int delete(BusRoute busRoute) {
		BusRouteDAOImpl busRouteDAOImpl = new BusRouteDAOImpl();
		int row = busRouteDAOImpl.delete(busRoute);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;

	}
	@Override
	public BusRoute busRouteid(int id) {
			BusRouteDAOImpl busRouteDAOImpl = new BusRouteDAOImpl();
			BusRoute busRoute = busRouteDAOImpl.busRouteid(id);
			
			return busRoute;
		}
}
