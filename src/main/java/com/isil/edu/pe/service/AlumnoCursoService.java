package com.isil.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AlumnoCursoModel;
import com.isil.edu.pe.repository.AlumnoCursoRepository;

@Service
public class AlumnoCursoService {
	
	private final AlumnoCursoRepository AlumnoCursoRepository = null;
	
	@Autowired
    private AlumnoCursoRepository alumnoCursoRepository;

    public List<AlumnoCursoModel> obtenerTodosAlumnosCursos() {
        return alumnoCursoRepository.findAll();
    }

    public AlumnoCursoModel obtenerAlumnoCursoPorId(Long id) throws ResourceNotFoundException {
        return alumnoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Alumno-Curso no encontrada con ID: " + id));
    }

    public AlumnoCursoModel crearAlumnoCurso(AlumnoCursoModel alumnoCurso) {
        return alumnoCursoRepository.save(alumnoCurso);
    }

    public AlumnoCursoModel actualizarAlumnoCurso(Long id, AlumnoCursoModel alumnoCursoDetalles) throws ResourceNotFoundException {
        AlumnoCursoModel alumnoCurso = AlumnoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Alumno-Curso no encontrada con ID: " + id));

        alumnoCurso.setAlumnoID(alumnoCursoDetalles.getAlumnoID());
        alumnoCurso.setCursoID(alumnoCursoDetalles.getCursoID());

        return alumnoCursoRepository.save(alumnoCurso);
    }

    public void eliminarAlumnoCurso(Long id) throws ResourceNotFoundException {
        AlumnoCursoModel alumnoCurso = alumnoCursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación Alumno-Curso no encontrada con ID: " + id));
        alumnoCursoRepository.delete(alumnoCurso);
    }

}
