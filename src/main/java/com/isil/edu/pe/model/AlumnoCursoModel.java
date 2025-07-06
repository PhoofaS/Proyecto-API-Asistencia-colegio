package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "AlumnoCurso", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"alumnoID", "cursoID"})
})
public class AlumnoCursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlumnoCursoID")
    private Long alumnoCursoID;

    @Column(name = "AlumnoID", nullable = false)
    private Long alumnoID;

    @Column(name = "CursoID", nullable = false)
    private Long cursoID;

    // Getters y Setters
    public Long getAlumnoCursoID() {
        return alumnoCursoID;
    }

    public void setAlumnoCursoID(Long alumnoCursoID) {
        this.alumnoCursoID = alumnoCursoID;
    }

    public Long getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(Long alumnoID) {
        this.alumnoID = alumnoID;
    }

    public Long getCursoID() {
        return cursoID;
    }

    public void setCursoID(Long cursoID) {
        this.cursoID = cursoID;
    }
}
