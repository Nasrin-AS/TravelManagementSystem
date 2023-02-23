package com.canddella.service;

import java.util.List;

import com.canddella.dao.OwnerDAOImpl;
import com.canddella.entity.Owner;

public class OwnerServiceImpl implements OwnerService {

	@Override
	public List<Owner> findAll() {
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		List<Owner> ownerList = ownerDAOImpl.findAll();
		return ownerList;

	}

	@Override
	public void save(Owner owner) {
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		int row = ownerDAOImpl.save(owner);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}
	@Override
	public int update(Owner owner) {
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		int row = ownerDAOImpl.update(owner);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public int delete(Owner owner) {
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		int row = ownerDAOImpl.delete(owner);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	}
	@Override
	public Owner ownerid(int id) {
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		Owner owner = ownerDAOImpl.ownerid(id);
		
		return owner;
	}

}
