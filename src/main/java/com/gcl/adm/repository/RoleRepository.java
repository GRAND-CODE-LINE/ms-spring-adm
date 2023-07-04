package com.gcl.adm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gcl.adm.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	//Page<Role> findByName(Role role, Pageable pageable);
	
	

}
