package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Salon")
public class SalonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalonID")
    private Integer salonID;

    @Column(name = "NombreSalon", nullable = false)
    private String nombreSalon;

    // Getters y Setters
    public Integer getSalonID() {
        return salonID;
    }

    public void setSalonID(Integer salonID) {
        this.salonID = salonID;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }
}
