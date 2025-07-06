package com.isil.edu.pe.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Asistencia", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"usuarioID", "cursoSalonID", "fecha"})
})
public class AsistenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AsistenciaID")
    private Long asistenciaID;

    @Column(name = "UsuarioID", nullable = false)
    private Long usuarioID;

    @Column(name = "CursoSalonID", nullable = false)
    private Long cursoSalonID;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "HoraRegistro", nullable = false)
    private LocalTime horaRegistro;

    // Getters y Setters
    public Long getAsistenciaID() {
        return asistenciaID;
    }

    public void setAsistenciaID(Long asistenciaID) {
        this.asistenciaID = asistenciaID;
    }

    public Long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Long getCursoSalonID() {
        return cursoSalonID;
    }

    public void setCursoSalonID(Long cursoSalonID) {
        this.cursoSalonID = cursoSalonID;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(LocalTime horaRegistro) {
        this.horaRegistro = horaRegistro;
    }
}
