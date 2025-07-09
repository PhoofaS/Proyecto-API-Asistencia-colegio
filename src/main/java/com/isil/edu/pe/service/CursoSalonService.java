package com.isil.edu.pe.service;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.CursoSalonModel;
import com.isil.edu.pe.repository.CursoSalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoSalonService {

    @Autowired
    private CursoSalonRepository cursoSalonRepository;

    public List<CursoSalonModel> obtenerTodosCursosSalones() {
        return cursoSalonRepository.findAll();
    }

    public CursoSalonModel obtenerCursoSalonPorId(Long id) throws ResourceNotFoundException {
        return cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Curso-Salón no encontrada con ID: " + id));
    }

    public CursoSalonModel crearCursoSalon(CursoSalonModel cursoSalon) {
        return cursoSalonRepository.save(cursoSalon);
    }

    public CursoSalonModel actualizarCursoSalon(Long id, CursoSalonModel cursoSalonDetalles) throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Curso-Salón no encontrada con ID: " + id));

        cursoSalon.setCursoID(cursoSalonDetalles.getCursoID());
        cursoSalon.setSalonID(cursoSalonDetalles.getSalonID());
        cursoSalon.setProfesorID(cursoSalonDetalles.getProfesorID());
        cursoSalon.setFechaAsignacion(cursoSalonDetalles.getFechaAsignacion());

        return cursoSalonRepository.save(cursoSalon);
    }

    public void eliminarCursoSalon(Long id) throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Curso-Salón no encontrada con ID: " + id));
        cursoSalonRepository.delete(cursoSalon);
    }
}