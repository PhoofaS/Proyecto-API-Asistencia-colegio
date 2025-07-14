package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Curso")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CursoID")
    private Integer cursoID;

    @Column(name = "NombreCurso", nullable = false)
    private String nombreCurso;

    // Getters y Setters
    public Integer getCursoID() {
        return cursoID;
    }

    public void setCursoID(Integer cursoID) {
        this.cursoID = cursoID;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
