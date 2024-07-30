package com.gcl.adm.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.gcl.dental.core.model.adm.Menu;

public interface MenuService {
	
	public List<Menu> index ();
	
	public Menu getById(String id);
	
	public Menu create(Menu menu);
	
	public Menu update(Menu menu);
	
	public void delete(String id);

	public Page<Menu> paginate(Map<String,String>filters);

}
