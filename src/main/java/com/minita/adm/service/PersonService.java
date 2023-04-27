package com.minita.adm.service;

import java.util.List;

import com.minita.adm.model.Person;

public interface PersonService  {
	
	public List<Person> index();
	
	public Person create(Person person);

	public Person update(Person person);
	
	public void delete(String id);

}
