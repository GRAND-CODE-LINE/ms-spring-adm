package com.gcl.adm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gcl.adm.model.Person;
import com.gcl.adm.service.PersonService;

//@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personservice;
	@CrossOrigin
	@GetMapping("listar")
	List<Person> index() {
		return personservice.index();
	}
	@CrossOrigin
	@GetMapping("{id}")
	public Person getById(@PathVariable String id){
		System.out.println(id);
		return personservice.getById(id);
	}
	@CrossOrigin
	@PostMapping("")
	public Person create(@RequestBody Person person) {
		return personservice.create(person);
	}
	@CrossOrigin
	@PutMapping("{id}")
	Person update(@PathVariable String id, @RequestBody Person person) {

		return personservice.update(person);
	}
	@CrossOrigin
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void delete(@PathVariable String id) {

		personservice.delete(id);
	}
	
	@CrossOrigin
	@PostMapping("paginate")
	Page<Person> paginate(@RequestBody Map<String, String>filter){
		return personservice.paginate(filter);
	}
}