package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Company;

public interface CompanyDAO {
	
	List<Company> findAll();
	int save(Company company);
	int update(Company company);
	int delete(Company company);
	Company companyid(int id);
}
