package com.canddella.service;

import java.util.List;

import com.canddella.entity.Bus;

public interface BusService {
	List<Bus> findall();
	int save(Bus bus);
	int update(Bus bus);
	int delete(Bus bus);
	Bus busid(int id);
}
