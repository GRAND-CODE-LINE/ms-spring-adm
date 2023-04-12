package com.minita.adm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.minita.adm.model.Person;

public interface PersonRepository extends MongoRepository<Person,Integer>{

}
	