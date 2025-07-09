package com.isil.edu.pe.service;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.ProfesorModel;
import com.isil.edu.pe.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<ProfesorModel> obtenerTodosProfesores() {
        return profesorRepository.findAll();
    }

    public ProfesorModel obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con ID: " + id));
    }

    public ProfesorModel crearProfesor(ProfesorModel profesor) {
        return profesorRepository.save(profesor);
    }

    public ProfesorModel actualizarProfesor(Long id, ProfesorModel profesorDetalles) {
        ProfesorModel profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con ID: " + id));

        profesor.setNombre(profesorDetalles.getNombre());
        profesor.setApellido(profesorDetalles.getApellido());
        profesor.setCorreoElectronico(profesorDetalles.getCorreoElectronico());
        profesor.setTelefono(profesorDetalles.getTelefono());

        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(Long id) {
        ProfesorModel profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con ID: " + id));
        profesorRepository.delete(profesor);
    }
}