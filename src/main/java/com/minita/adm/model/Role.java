package com.minita.adm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Document(collection = "roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
	@Id
	private String id;
	@NotBlank
	private String name;
	
	
	
	public Role(String id, @NotBlank String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
