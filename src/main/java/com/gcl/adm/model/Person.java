package com.gcl.adm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;


@Document(collection = "persons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	@Id
	private String id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apaterno;
	@NotBlank
	private String amaterno;
	
	private String email;
	@NotBlank
	private String tipoDocumento;
	@NotBlank
	private Integer numeroDocumento;
	@NotBlank
	private Date fechaNacimiento;
	
	
	
	
	
	public Person(String id, @NotBlank String nombre, @NotBlank String apaterno, @NotBlank String amaterno,
			String email, @NotBlank String tipoDocumento, @NotBlank int numeroDocumento,
			@NotBlank Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.email = email;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
