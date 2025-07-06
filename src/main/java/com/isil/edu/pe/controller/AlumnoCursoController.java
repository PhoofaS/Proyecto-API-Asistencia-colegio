package com.isil.edu.pe.controller;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AlumnoCursoModel;
import com.isil.edu.pe.repository.AlumnoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class AlumnoCursoController {

    @Autowired
    private AlumnoCursoRepository alumnoCursoRepository;

    // Obtener todos los registros alumno-curso
    @GetMapping("/alumnocurso")
    public List<AlumnoCursoModel> getAllAlumnoCursos() {
        return alumnoCursoRepository.findAll();
    }

    // Obtener uno por ID
    @GetMapping("/alumnocurso/{id}")
    public ResponseEntity<AlumnoCursoModel> getAlumnoCursoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        AlumnoCursoModel alumnoCurso = alumnoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AlumnoCurso no encontrado con ID: " + id));
        return ResponseEntity.ok(alumnoCurso);
    }

    // Crear nuevo registro
    @PostMapping("/alumnocurso")
    public AlumnoCursoModel createAlumnoCurso(@Validated @RequestBody AlumnoCursoModel alumnoCurso) {
        return alumnoCursoRepository.save(alumnoCurso);
    }

    // Actualizar registro existente
    @PutMapping("/alumnocurso/{id}")
    public ResponseEntity<AlumnoCursoModel> updateAlumnoCurso(@PathVariable Long id,
            @Validated @RequestBody AlumnoCursoModel alumnoCursoDetails) throws ResourceNotFoundException {
        AlumnoCursoModel alumnoCurso = alumnoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AlumnoCurso no encontrado con ID: " + id));

        alumnoCurso.setAlumnoID(alumnoCursoDetails.getAlumnoID());
        alumnoCurso.setCursoID(alumnoCursoDetails.getCursoID());

        return ResponseEntity.ok(alumnoCursoRepository.save(alumnoCurso));
    }

    // Eliminar registro
    @DeleteMapping("/alumnocurso/{id}")
    public Map<String, Boolean> deleteAlumnoCurso(@PathVariable Long id) throws ResourceNotFoundException {
        AlumnoCursoModel alumnoCurso = alumnoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AlumnoCurso no encontrado con ID: " + id));

        alumnoCursoRepository.delete(alumnoCurso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
