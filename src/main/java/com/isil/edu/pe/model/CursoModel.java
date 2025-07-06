package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Curso")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CursoID")
    private Long cursoID;

    @Column(name = "NombreCurso", nullable = false, length = 100)
    private String nombreCurso;

    // Getters y Setters
    public Long getCursoID() {
        return cursoID;
    }

    public void setCursoID(Long cursoID) {
        this.cursoID = cursoID;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
