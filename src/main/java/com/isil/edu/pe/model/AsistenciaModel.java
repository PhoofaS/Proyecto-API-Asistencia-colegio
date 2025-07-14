package com.isil.edu.pe.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Asistencia", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"UsuarioID", "CursoSalonID", "Fecha"})
})
public class AsistenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AsistenciaID")
    private Integer asistenciaID;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "CursoSalonID", nullable = false)
    private CursoSalonModel cursoSalon;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "HoraRegistro", nullable = false)
    private LocalTime horaRegistro;

    // Getters y Setters

    public Integer getAsistenciaID() {
        return asistenciaID;
    }

    public void setAsistenciaID(Integer asistenciaID) {
        this.asistenciaID = asistenciaID;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public CursoSalonModel getCursoSalon() {
        return cursoSalon;
    }

    public void setCursoSalon(CursoSalonModel cursoSalon) {
        this.cursoSalon = cursoSalon;
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
