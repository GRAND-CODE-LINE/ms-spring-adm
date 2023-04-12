package com.minita.adm.services;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public String getPerson() {
		return "A";
	}
}
