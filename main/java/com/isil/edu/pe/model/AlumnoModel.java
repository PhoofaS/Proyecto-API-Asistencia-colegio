package com.isil.edu.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class AlumnoModel {

	private Long AlumnoId;
	private String Nombre;
	private String Apellido;
	private Long UsuarioId;

private AlumnoModel() {
	
}

public AlumnoModel(Long alumnoId, String nombre, String apellido, Long usuarioId) {
	super();
	this.AlumnoId = alumnoId;
	this.Nombre = nombre;
	this.Apellido = apellido;
	this.UsuarioId = usuarioId;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

public Long getAlumnoId() {
	return AlumnoId;
}

public void setAlumnoId(Long alumnoId) {
	AlumnoId = alumnoId;
}

@Column(name="Nombre", nullable=false)

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

@Column(name="Apellido", nullable=false)

public String getApellido() {
	return Apellido;
}

public void setApellido(String apellido) {
	Apellido = apellido;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

public Long getUsuarioId() {
	return UsuarioId;
}

public void setUsuarioId(Long usuarioId) {
	UsuarioId = usuarioId;
}
}
