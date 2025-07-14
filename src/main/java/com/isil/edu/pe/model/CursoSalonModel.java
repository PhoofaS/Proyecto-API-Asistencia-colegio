package com.isil.edu.pe.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CursoSalon", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CursoID", "SalonID", "FechaAsignacion"})
})
public class CursoSalonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CursoSalonID")
    private Integer cursoSalonID;

    @ManyToOne
    @JoinColumn(name = "CursoID", nullable = false)
    private CursoModel curso;

    @ManyToOne
    @JoinColumn(name = "SalonID", nullable = false)
    private SalonModel salon;

    @ManyToOne
    @JoinColumn(name = "ProfesorID", nullable = false)
    private ProfesorModel profesor;

    @Column(name = "FechaAsignacion", nullable = false)
    private LocalDate fechaAsignacion;

    // === Getters y Setters ===

    public Integer getCursoSalonID() {
        return cursoSalonID;
    }

    public void setCursoSalonID(Integer cursoSalonID) {
        this.cursoSalonID = cursoSalonID;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public SalonModel getSalon() {
        return salon;
    }

    public void setSalon(SalonModel salon) {
        this.salon = salon;
    }

    public ProfesorModel getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorModel profesor) {
        this.profesor = profesor;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
