package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Bill;

public interface BillDAO {
	List<Bill> findAll();
	int save(Bill bill);
	int update(Bill bill);
	int delete(Bill bill);
	Bill billid(int id);
}
