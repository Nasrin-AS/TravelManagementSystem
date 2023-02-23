package com.canddella.dao;

import java.util.List;
import com.canddella.entity.Owner;

public interface OwnerDAO {
	List<Owner> findAll();
	int save(Owner owner);
	int update(Owner owner);
	int delete(Owner owner);
	Owner ownerid(int id);
}
