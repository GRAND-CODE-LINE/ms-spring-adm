package com.gcl.adm.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.gcl.adm.model.Role;

public interface RoleService {

	Role save(Role role);

	Role edit(Role role);

	void delete(Role role);

	Page<Role>  paginate(Map<String, String> filters);

}
