package com.isil.edu.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Salon")
public class SalonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalonID")
    private Long salonID;

    @Column(name = "NombreSalon", nullable = false, length = 50)
    private String nombreSalon;

    // Getters y Setters
    public Long getSalonID() {
        return salonID;
    }

    public void setSalonID(Long salonID) {
        this.salonID = salonID;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }
}
