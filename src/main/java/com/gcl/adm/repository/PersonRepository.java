package com.gcl.adm.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcl.adm.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	Person findByNumeroDocumento(String numeroDocumento);
}
