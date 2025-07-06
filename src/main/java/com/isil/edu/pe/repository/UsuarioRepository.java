package com.isil.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isil.edu.pe.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
