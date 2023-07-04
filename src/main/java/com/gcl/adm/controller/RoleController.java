package com.gcl.adm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcl.adm.model.Person;
import com.gcl.adm.model.Role;
import com.gcl.adm.service.PersonService;
import com.gcl.adm.service.RoleService;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@CrossOrigin
	@PostMapping("paginate")
	Page<Role> paginate(@RequestBody Map<String, String> filter) {
		return roleService.paginate(filter);
	}

}
