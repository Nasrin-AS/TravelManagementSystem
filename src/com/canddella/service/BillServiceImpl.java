package com.canddella.service;

import java.util.List;

import com.canddella.dao.BillDAOImpl;
import com.canddella.dao.BusDAOImpl;
import com.canddella.entity.Bill;
import com.canddella.entity.Bus;

public class BillServiceImpl implements BillService {

	@Override
	public List<Bill> findall() {

		BillDAOImpl billDAOImpl = new BillDAOImpl();
		List<Bill> billList = billDAOImpl.findAll();
		return billList;
	}
	@Override
	public int save(Bill bill) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.save(bill);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	
		return 0;
	}

	@Override
	public int update(Bill bill) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.update(bill);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public int delete(Bill bill) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.delete(bill);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	}
	@Override
	public Bill billid(int id) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		Bill bill = billDAOImpl.billid(id);
		
		return bill;
	}

}
