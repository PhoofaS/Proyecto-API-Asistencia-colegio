package com.isil.edu.pe.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CursoSalon", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cursoID", "salonID", "fechaAsignacion"})
})
public class CursoSalonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CursoSalonID")
    private Long cursoSalonID;

    @Column(name = "CursoID", nullable = false)
    private Long cursoID;

    @Column(name = "SalonID", nullable = false)
    private Long salonID;

    @Column(name = "ProfesorID", nullable = false)
    private Long profesorID;

    @Column(name = "FechaAsignacion", nullable = false)
    private LocalDate fechaAsignacion;

    // Getters y Setters
    public Long getCursoSalonID() {
        return cursoSalonID;
    }

    public void setCursoSalonID(Long cursoSalonID) {
        this.cursoSalonID = cursoSalonID;
    }

    public Long getCursoID() {
        return cursoID;
    }

    public void setCursoID(Long cursoID) {
        this.cursoID = cursoID;
    }

    public Long getSalonID() {
        return salonID;
    }

    public void setSalonID(Long salonID) {
        this.salonID = salonID;
    }

    public Long getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(Long profesorID) {
        this.profesorID = profesorID;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
