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

@CrossOrigin
@RestController
@RequestMapping("/Person")
public class PersonController {

	@Autowired
	private PersonRepository personainterface;
	
	@GetMapping("listar")
	List<Person> index(){
		return personainterface.findAll();
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("create")
	Person create(@RequestBody Person person) {
	return personainterface.save(person);
	}
	@PutMapping("{id}")
	Person update(@PathVariable Integer id,@RequestBody Person person){
		Person persondb = personainterface
				.findById(id)
				.orElseThrow(RuntimeException::new);
	persondb.setNombre(person.getNombre());
	persondb.setAmaterno(person.getAmaterno());
	persondb.setApaterno(person.getApaterno());
	persondb.setEmail(person.getEmail());
	persondb.setFechaNacimiento(person.getFechaNacimiento());
	persondb.setNumeroDocumento(person.getNumeroDocumento());
	persondb.setTipoDocumento(person.getTipoDocumento());
	
	return personainterface.save(persondb);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void delete(@PathVariable Integer id) {
		Person persondb = personainterface
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		personainterface.delete(persondb);
	}
}
