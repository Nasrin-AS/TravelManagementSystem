package com.canddella.service;

import java.util.List;

import com.canddella.dao.CompanyDAOImpl;
import com.canddella.entity.Company;

public class CompanyServiceImpl implements CompanyService {

	@Override
	public List<Company> findAll() {
		CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
		List<Company> companyList = companyDAOImpl.findAll();
		return companyList;
	}

	@Override
	public void save(Company company) {
		CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
		int row = companyDAOImpl.save(company);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}
	@Override
	public int update(Company company) {
		CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
		int row = companyDAOImpl.update(company);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}
	@Override
	public int delete(Company company) {
		CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
		int row = companyDAOImpl.delete(company);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public Company companyid(int id) {
		CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
		Company company = companyDAOImpl.companyid(id);
		
		return company;
	}

}
