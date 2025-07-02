package com.isil.edu.pe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AlumnoModel;
import com.isil.edu.pe.repository.AlumnoRepository;

@RestController
@RequestMapping("/api/v1")
public class AlumnoController {
	
	@Autowired //inyeccion de dependencias
	private AlumnoRepository alumnoRepository;
	
	@GetMapping("alumno")//consulta y devuelve todos los alumnos
	private List<AlumnoModel> getAllAlumno() {
		return alumnoRepository.findAll();
	}
	
	@GetMapping("/alumno/{AlumnoId}") // consulta y devuelve el empleado por ID
	public ResponseEntity<AlumnoModel> getAlumnoId(@PathVariable(value = "AlumnoId") Long alumnoId)
	         throws ResourceNotFoundException {
		AlumnoModel alumno = alumnoRepository.findById(alumnoId).orElseThrow(()->
		new  ResourceNotFoundException ("Alumno no encontrado por ID: " + alumnoId));
		return ResponseEntity.ok(alumno);
	
	}
	
	@PostMapping("/alumno") // se usa para crear o guardar en base de datos
	public AlumnoModel createAlumno(@Validated @RequestBody AlumnoModel alumno) {
		return alumnoRepository.save(alumno);
	}
	
	@PutMapping("/alumno/{AlumnoId}")// se usa para actualizar los alumnos
	public  ResponseEntity<AlumnoModel> updateAlumno(@PathVariable(value = "AlumnoId")Long alumnoId,
			@Validated @RequestBody AlumnoModel alumnoDetails) throws ResourceNotFoundException{
		
	AlumnoModel alumno = alumnoRepository.findById(alumnoId)
		.orElseThrow(() -> new ResourceNotFoundException("Alumno no ha sido encontrado por el ID : " + alumnoId));
	    
	alumno.setNombre(alumnoDetails.getNombre());
	alumno.setApellido(alumnoDetails.getApellido());
	final AlumnoModel updateAlumno = alumnoRepository.save(alumno);
	return ResponseEntity.ok(updateAlumno);
		
	}
	
	@DeleteMapping("/alumno/{AlumnoId}") // se utiliza para la eliminación del alumno por ID
	public Map<String,Boolean> deleteAlumno(@PathVariable(value = "AlumnoId")Long alumnoId)
	        throws ResourceNotFoundException
	
	{
		AlumnoModel alumno = alumnoRepository.findById(alumnoId)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no se encuentra el ID :" + alumnoId));
		 alumnoRepository.delete(alumno);
		 Map<String, Boolean> response = new HashMap<>();
		 response.put("delete", Boolean.TRUE);
		 return response;
		
	}

}
