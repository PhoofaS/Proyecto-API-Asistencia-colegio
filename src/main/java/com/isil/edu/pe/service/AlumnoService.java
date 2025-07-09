package com.isil.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AlumnoModel;
import com.isil.edu.pe.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	private final AlumnoRepository alumnoRepository;
	
	public AlumnoService(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}
	
	public List<AlumnoModel> obtenerTodosAlumnos() {
		return alumnoRepository.findAll();
	}
	
	public AlumnoModel obtenerAlumnoPorId(Long id) throws ResourceNotFoundException {
		return alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));
	}
	
	public AlumnoModel crearAlumno(AlumnoModel alumno) {
		return alumnoRepository.save(alumno);
	}
	
	public AlumnoModel actualizarAlumno(Long id, AlumnoModel alumnoDetalles) throws ResourceNotFoundException {
		AlumnoModel alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));
		
		alumno.setUsuarioId(alumnoDetalles.getUsuarioId());
		alumno.setNombre(alumnoDetalles.getNombre());
		alumno.setApellido(alumnoDetalles.getApellido());
		
		return alumnoRepository.save(alumno);
	}
	public void eliminarAlumno(Long id) throws ResourceNotFoundException {
		AlumnoModel alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID :" + id));
		alumnoRepository.delete(alumno);
	}
	

}
