package com.minita.adm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.minita.adm.model.Person;
import com.minita.adm.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personainterface;

	public List<Person> index() {
		return personainterface.findAll();
	}

	public	Person create(Person person) {
		return personainterface.save(person);
	}

	public Person update(Person person) {
		return personainterface.save(person);
	}

	public void delete(String id) {
		Person persondb = personainterface.findById(id).orElseThrow(RuntimeException::new);

		personainterface.delete(persondb);
	}
}
