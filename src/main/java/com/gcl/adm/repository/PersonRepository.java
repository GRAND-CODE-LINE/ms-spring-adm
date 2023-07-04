package com.gcl.adm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcl.adm.model.Person;

public interface PersonRepository extends MongoRepository<Person,String>{

}
	