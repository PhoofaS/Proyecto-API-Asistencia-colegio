package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = "DocumentoIdentidad")
})
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID")
    private Integer usuarioID;

    @Column(name = "DocumentoIdentidad", nullable = false, length = 20, unique = true)
    private String documentoIdentidad;

    @Column(name = "NombreCompleto", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "Contrasena", nullable = false, length = 100)
    private String contrasena;

    @Column(name = "EsAdministrador", nullable = false)
    private Boolean esAdministrador = false;

    // === Getters y Setters ===

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(Boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
}


