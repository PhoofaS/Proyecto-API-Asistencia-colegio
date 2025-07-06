package com.isil.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isil.edu.pe.model.SalonModel;

public interface SalonRepository extends JpaRepository<SalonModel, Long> {
}
