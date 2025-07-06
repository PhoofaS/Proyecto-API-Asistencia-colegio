package com.isil.edu.pe.controller;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.CursoModel;
import com.isil.edu.pe.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // Obtener todos los cursos
    @GetMapping("/curso")
    public List<CursoModel> getAllCursos() {
        return cursoRepository.findAll();
    }

    // Obtener curso por ID
    @GetMapping("/curso/{id}")
    public ResponseEntity<CursoModel> getCursoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        CursoModel curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));
        return ResponseEntity.ok(curso);
    }

    // Crear nuevo curso
    @PostMapping("/curso")
    public CursoModel createCurso(@Validated @RequestBody CursoModel curso) {
        return cursoRepository.save(curso);
    }

    // Actualizar curso existente
    @PutMapping("/curso/{id}")
    public ResponseEntity<CursoModel> updateCurso(@PathVariable Long id,
            @Validated @RequestBody CursoModel cursoDetails) throws ResourceNotFoundException {
        CursoModel curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));

        curso.setNombreCurso(cursoDetails.getNombreCurso());
        return ResponseEntity.ok(cursoRepository.save(curso));
    }

    // Eliminar curso
    @DeleteMapping("/curso/{id}")
    public Map<String, Boolean> deleteCurso(@PathVariable Long id) throws ResourceNotFoundException {
        CursoModel curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));

        cursoRepository.delete(curso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
