package com.canddella.service;

import java.util.List;
import com.canddella.entity.Owner;

public interface OwnerService {
	List<Owner> findAll();
	void save(Owner owner);
	int update(Owner owner);
	int delete(Owner owner);
	Owner ownerid(int id);

}
