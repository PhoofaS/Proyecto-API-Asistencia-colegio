package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumno")
public class AlumnoModel {

    @Id
    @Column(name = "AlumnoID")
    private Integer alumnoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "AlumnoID", referencedColumnName = "UsuarioID")
    private UsuarioModel usuario;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    public AlumnoModel() {}

    public AlumnoModel(UsuarioModel usuario, String nombre, String apellido) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

