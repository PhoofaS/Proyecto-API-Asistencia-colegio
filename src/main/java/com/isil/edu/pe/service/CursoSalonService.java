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

    public CursoSalonModel obtenerCursoSalonPorId(Integer id) throws ResourceNotFoundException {
        return cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Curso-Salón no encontrada con ID: " + id));
    }

    public CursoSalonModel crearCursoSalon(CursoSalonModel cursoSalon) {
        return cursoSalonRepository.save(cursoSalon);
    }

    public CursoSalonModel actualizarCursoSalon(Integer id, CursoSalonModel cursoSalonDetalles) throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Curso-Salón no encontrada con ID: " + id));

        cursoSalon.setCurso(cursoSalonDetalles.getCurso());
        cursoSalon.setSalon(cursoSalonDetalles.getSalon());  // Corregido
        cursoSalon.setProfesor(cursoSalonDetalles.getProfesor());
        cursoSalon.setFechaAsignacion(cursoSalonDetalles.getFechaAsignacion());

        return cursoSalonRepository.save(cursoSalon);
    }
    public void eliminarCursoSalon(Integer id) throws ResourceNotFoundException {
        CursoSalonModel cursoSalon = cursoSalonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Curso-Salón no encontrada con ID: " + id));
        cursoSalonRepository.delete(cursoSalon);
    }
}