package com.gcl.adm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcl.adm.service.MenuService;
import com.gcl.dental.core.model.adm.Menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuservice;
	@CrossOrigin
	@GetMapping("listar")
	public List<Menu> index() {
		return menuservice.index();
	}
	
	@CrossOrigin
	@GetMapping("{id}")
	public Menu getById(@PathVariable String id) {
		return menuservice.getById(id);		
	}
	
	@CrossOrigin
	@PostMapping("")
	public Menu create(@RequestBody Menu menu) {
		//TODO: process POST request
		return menuservice.create(menu);
	}
	
	@CrossOrigin
	@PutMapping("{id}")
	public Menu update(@PathVariable String id, @RequestBody Menu menu) {
		//TODO: process PUT request
		return menuservice.update(menu);
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		menuservice.delete(id);
	}
	
	@CrossOrigin
	@PostMapping("paginate")
	public Page<Menu> paginate(@RequestBody Map<String, String>filter){
		return menuservice.paginate(filter);
	}
	
	
}
