package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Bus;

public interface BusDAO {
	List<Bus> findAll();
	int save(Bus bus);
	int update(Bus bus);
	int delete(Bus bus);
	Bus busid(int id);
}
