package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Profesor")
public class ProfesorModel {

    @Id
    @Column(name = "ProfesorID")
    private Integer profesorID;

    @OneToOne
    @JoinColumn(name = "ProfesorID", referencedColumnName = "UsuarioID", insertable = false, updatable = false)
    private UsuarioModel usuario;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "CorreoElectronico")
    private String correoElectronico;

    @Column(name = "Telefono")
    private String telefono;

    // === Constructores ===

    public ProfesorModel() {
    }

    public ProfesorModel(Integer profesorID, String nombre, String apellido, String correoElectronico, String telefono) {
        this.profesorID = profesorID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    // === Getters y Setters ===

    public Integer getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(Integer profesorID) {
        this.profesorID = profesorID;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
