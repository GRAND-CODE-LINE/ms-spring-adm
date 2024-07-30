package com.gcl.adm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcl.dental.core.model.adm.Menu;
import com.gcl.dental.core.repository.adm.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository menurepository;
	
	public List<Menu> index() {
		return menurepository.findAll();
	}
	
	public Menu getById(String id){
		Menu menudb= menurepository.findById(id).orElseThrow(RuntimeException :: new);
		return menudb;
	}

	public Menu create(Menu Menu) {
		return menurepository.save(Menu);
	}

	public Menu update(Menu Menu) {

		return menurepository.save(Menu);
	}

	public void delete( String id) {
		Menu menudb = menurepository.findById(id).orElseThrow(RuntimeException :: new);
		menurepository.delete(menudb);
	}
	
	
	public Page<Menu> paginate( Map<String, String>filters){
		
		ObjectMapper mapper = new ObjectMapper();
		Menu pojo = mapper.convertValue(filters, Menu.class);
		
		Integer page = filters.get("page") != null ? Integer.parseInt(filters.get("page")) : 0;

		Integer size = filters.get("size") != null ? Integer.parseInt(filters.get("size")) : 10;

		Integer sortOrder = filters.get("sortOrder") != null ? Integer.parseInt(filters.get("sortOrder")) : 1;

		String sortField = filters.get("sortField") != null ? filters.get("sortField") : "id";

		Sort sort = sortOrder == 1 ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(page, size, sort);

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnoreNullValues()
				.withStringMatcher(StringMatcher.REGEX).withIgnoreCase(true)
				.withMatcher("nombre", GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.REGEX).ignoreCase());
		
		Example<Menu> example =Example.of(pojo,matcher);
		
		return menurepository.findAll(example,pageable);
	}	

}
