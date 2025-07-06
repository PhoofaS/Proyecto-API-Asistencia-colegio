package com.isil.edu.pe.controller;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.CursoSalonModel;
import com.isil.edu.pe.repository.CursoSalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class CursoSalonController {

    @Autowired
    private CursoSalonRepository cursoSalonRepository;

    @GetMapping("/cursosalon")
    public List<CursoSalonModel> getAllCursoSalon() {
        return cursoSalonRepository.findAll();
    }

    @GetMapping("/cursosalon/{id}")
    public ResponseEntity<CursoSalonModel> getCursoSalonById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CursoSalon no encontrado con ID: " + id));
        return ResponseEntity.ok(cursoSalon);
    }

    @PostMapping("/cursosalon")
    public CursoSalonModel createCursoSalon(@Validated @RequestBody CursoSalonModel cursoSalon) {
        return cursoSalonRepository.save(cursoSalon);
    }

    @PutMapping("/cursosalon/{id}")
    public ResponseEntity<CursoSalonModel> updateCursoSalon(@PathVariable Long id,
            @Validated @RequestBody CursoSalonModel cursoSalonDetails) throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CursoSalon no encontrado con ID: " + id));

        cursoSalon.setCursoID(cursoSalonDetails.getCursoID());
        cursoSalon.setSalonID(cursoSalonDetails.getSalonID());
        cursoSalon.setProfesorID(cursoSalonDetails.getProfesorID());
        cursoSalon.setFechaAsignacion(cursoSalonDetails.getFechaAsignacion());

        return ResponseEntity.ok(cursoSalonRepository.save(cursoSalon));
    }

    @DeleteMapping("/cursosalon/{id}")
    public Map<String, Boolean> deleteCursoSalon(@PathVariable Long id) throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CursoSalon no encontrado con ID: " + id));

        cursoSalonRepository.delete(cursoSalon);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
