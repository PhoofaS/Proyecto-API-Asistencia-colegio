package com.isil.edu.pe.controller;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.SalonModel;
import com.isil.edu.pe.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class SalonController {

    @Autowired
    private SalonRepository salonRepository;

    // Obtener todos los salones
    @GetMapping("/salon")
    public List<SalonModel> getAllSalones() {
        return salonRepository.findAll();
    }

    // Obtener salón por ID
    @GetMapping("/salon/{id}")
    public ResponseEntity<SalonModel> getSalonById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        SalonModel salon = salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salón no encontrado con ID: " + id));
        return ResponseEntity.ok(salon);
    }

    // Crear nuevo salón
    @PostMapping("/salon")
    public SalonModel createSalon(@Validated @RequestBody SalonModel salon) {
        return salonRepository.save(salon);
    }

    // Actualizar salón existente
    @PutMapping("/salon/{id}")
    public ResponseEntity<SalonModel> updateSalon(@PathVariable Integer id,
            @Validated @RequestBody SalonModel salonDetails) throws ResourceNotFoundException {
        SalonModel salon = salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salón no encontrado con ID: " + id));

        salon.setNombreSalon(salonDetails.getNombreSalon());
        return ResponseEntity.ok(salonRepository.save(salon));
    }

    // Eliminar salón
    @DeleteMapping("/salon/{id}")
    public Map<String, Boolean> deleteSalon(@PathVariable Integer id) throws ResourceNotFoundException {
        SalonModel salon = salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salón no encontrado con ID: " + id));

        salonRepository.delete(salon);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}

