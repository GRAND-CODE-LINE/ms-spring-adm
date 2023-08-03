package com.gcl.adm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcl.adm.model.Person;
import com.gcl.adm.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personainterface;

	public List<Person> index() {
		return personainterface.findAll();
	}

	public Person getById(String id) {
		System.out.println("soy el Id " + id);

		Person persondb = personainterface.findById(id).orElseThrow(RuntimeException::new);
		return persondb;
	}

	public Person create(Person person) {
		return personainterface.save(person);
	}

	public Person update(Person person) {
		return personainterface.save(person);
	}

	public void delete(String id) {
		Person persondb = personainterface.findById(id).orElseThrow(RuntimeException::new);
		personainterface.delete(persondb);
	}

	@Override
	public Page<Person> paginate(Map<String, String> filters) {

		ObjectMapper mapper = new ObjectMapper();
		Person pojo = mapper.convertValue(filters, Person.class);

		Integer page = filters.get("page") != null ? Integer.parseInt(filters.get("page")) : 0;

		Integer size = filters.get("size") != null ? Integer.parseInt(filters.get("size")) : 10;

		Integer sortOrder = filters.get("sortOrder") != null ? Integer.parseInt(filters.get("sortOrder")) : 1;

		String sortField = filters.get("sortField") != null ? filters.get("sortField") : "id";

		Sort sort = sortOrder == 1 ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(page, size, sort);

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnoreNullValues()
				.withStringMatcher(StringMatcher.REGEX).withIgnoreCase(true)
				.withMatcher("nombre", GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.REGEX).ignoreCase());

		Example<Person> example = Example.of(pojo, matcher);

		return personainterface.findAll(example, pageable);

	}

	public Person getByDocument(String numeroDocumento) {

		Person persondb = personainterface.findByNumeroDocumento(numeroDocumento);
		//System.out.println(persondb.getFechaNacimiento());
		return persondb;
	}


}
