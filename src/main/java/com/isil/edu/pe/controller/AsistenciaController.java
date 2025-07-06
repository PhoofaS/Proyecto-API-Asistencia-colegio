package com.isil.edu.pe.controller;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AsistenciaModel;
import com.isil.edu.pe.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Obtener todas las asistencias
    @GetMapping("/asistencia")
    public List<AsistenciaModel> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    // Obtener asistencia por ID
    @GetMapping("/asistencia/{id}")
    public ResponseEntity<AsistenciaModel> getAsistenciaById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        AsistenciaModel asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con ID: " + id));
        return ResponseEntity.ok(asistencia);
    }

    // Crear nueva asistencia
    @PostMapping("/asistencia")
    public AsistenciaModel createAsistencia(@Validated @RequestBody AsistenciaModel asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    // Actualizar asistencia existente
    @PutMapping("/asistencia/{id}")
    public ResponseEntity<AsistenciaModel> updateAsistencia(@PathVariable Long id,
            @Validated @RequestBody AsistenciaModel asistenciaDetails) throws ResourceNotFoundException {
        AsistenciaModel asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con ID: " + id));

        asistencia.setUsuarioID(asistenciaDetails.getUsuarioID());
        asistencia.setCursoSalonID(asistenciaDetails.getCursoSalonID());
        asistencia.setFecha(asistenciaDetails.getFecha());
        asistencia.setHoraRegistro(asistenciaDetails.getHoraRegistro());

        return ResponseEntity.ok(asistenciaRepository.save(asistencia));
    }

    // Eliminar asistencia
    @DeleteMapping("/asistencia/{id}")
    public Map<String, Boolean> deleteAsistencia(@PathVariable Long id) throws ResourceNotFoundException {
        AsistenciaModel asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con ID: " + id));

        asistenciaRepository.delete(asistencia);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
