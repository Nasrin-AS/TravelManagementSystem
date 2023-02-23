package com.canddella.service;

import java.util.List;

import com.canddella.entity.BusRoute;

public interface BusRouteService {
	List<BusRoute> findall();
	int save(BusRoute busRoute);
	int update(BusRoute busRoute);
	int delete(BusRoute busRoute);
	BusRoute busRouteid(int id);
	
}
