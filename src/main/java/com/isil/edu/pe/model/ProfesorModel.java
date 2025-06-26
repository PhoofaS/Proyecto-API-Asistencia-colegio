package com.isil.edu.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="profesor")
public class ProfesorModel {

	private Long ProfesorId;
	private String Nombre;
	private String Apellido;
	private String CorreoElectronico;
  private Long Telefono;

private ProfesorModel() {
	
}

public ProfesorModel(Long ProfesorId, String Nombre, String Apellido, String CorreoElectronico, Long Telefono) {
	super();
	this.ProfesorId = ProfesorId;
	this.Nombre = Nombre;
	this.Apellido = Apellido;
  this.CorreoElectronico = CorreoElectronico;
	this.Telefono = Telefono;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

public Long getProfesorId() {
	return ProfesorId;
}

public void setProfesorId(Long NuevoProfesorId) {
	ProfesorId = NuevoProfesorId;
}

@Column(name="Nombre", nullable=false)

public String getNombre() {
	return Nombre;
}

public void setNombre(String NuevoNombre) {
	Nombre = NuevoNombre;
}

@Column(name="Apellido", nullable=false)

public String getApellido() {
	return Apellido;
}

public void setApellido(String NuevoApellido) {
	Apellido = NuevoApellido;
}

@Column(name="CorreoElectronico", nullable=false)

public String getCorreoElectronico() {
	return CorreoElectronico;
}

public void setCorreoElectronico(String NuevoCorreoElectronico) {
	CorreoElectroico = NuevoCorreoElectronico;
}
  
@Column(name = "telefono")
  
public Long getTelefono() {
  return telefono;
}

public void setTelefono(Long telefono) {
  this.telefono = telefono;
}
}
