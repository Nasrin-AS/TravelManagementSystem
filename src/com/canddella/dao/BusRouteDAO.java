package com.canddella.dao;

import java.util.List;

import com.canddella.entity.BusRoute;

public interface BusRouteDAO {
	List<BusRoute> findAll();
	int save(BusRoute busRoute);
	int update(BusRoute busRoute);
	int delete(BusRoute busRoute);
	BusRoute busRouteid(int id);

}
