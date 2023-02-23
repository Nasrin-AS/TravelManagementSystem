package com.canddella.service;

import java.util.List;

import com.canddella.entity.Company;

public interface CompanyService {
	
	List<Company> findAll();
	void save(Company company);
	int update(Company company);
	int delete(Company company);
	Company companyid(int id);

}
