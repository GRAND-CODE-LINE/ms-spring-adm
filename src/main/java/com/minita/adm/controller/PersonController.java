package com.minita.adm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
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

import com.minita.adm.model.Person;
import com.minita.adm.repository.PersonRepository;

import com.minita.adm.service.PersonService;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personservice;

	@GetMapping("listar")
	List<Person> index() {
		return personservice.index();
	}

	@PostMapping("/create")
	public Person create(@RequestBody Person person) {
		return personservice.create(person);
	}

	@PutMapping("{id}")
	Person update(@PathVariable Integer id, @RequestBody Person person) {

		return personservice.update(person);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void delete(@PathVariable Integer id) {

		personservice.delete(id);

}
