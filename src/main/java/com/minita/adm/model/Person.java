package com.minita.adm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Person {
@Id
 private Integer id;

 private String Nombre;
 
 private String Apaterno;
 
 private String Amaterno;
 
 private String Email;
 
 private String TipoDocumento;
 
 private int NumeroDocumento;
 
 private Date FechaNacimiento;
 

public Person(String nombre, String apaterno, String amaterno, String email, String tipoDocumento, int numeroDocumento,
		Date fechaNacimiento) {
	super();
	Nombre = nombre;
	Apaterno = apaterno;
	Amaterno = amaterno;
	Email = email;
	TipoDocumento = tipoDocumento;
	NumeroDocumento = numeroDocumento;
	FechaNacimiento = fechaNacimiento;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

public String getApaterno() {
	return Apaterno;
}

public void setApaterno(String apaterno) {
	Apaterno = apaterno;
}

public String getAmaterno() {
	return Amaterno;
}

public void setAmaterno(String amaterno) {
	Amaterno = amaterno;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getTipoDocumento() {
	return TipoDocumento;
}

public void setTipoDocumento(String tipoDocumento) {
	TipoDocumento = tipoDocumento;
}

public int getNumeroDocumento() {
	return NumeroDocumento;
}

public void setNumeroDocumento(int numeroDocumento) {
	NumeroDocumento = numeroDocumento;
}

public Date getFechaNacimiento() {
	return FechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento) {
	FechaNacimiento = fechaNacimiento;
}

}
