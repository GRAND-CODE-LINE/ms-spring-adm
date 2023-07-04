package com.gcl.adm.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.gcl.adm.model.Person;

public interface PersonService  {
	
	public List<Person> index();
	
	public Person create(Person person);

	public Person update(Person person);
	
	public void delete(String id);
	
	public Page<Person> paginate(Map<String,String> filters);

}
