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

import com.isil.edu.pe.model.ProfesorModel;
import com.isil.edu.pe.repository.ProfesorRepository;

@RestController
@RequestMapping("/api/v1")
public class ProfesorController {
	
	@Autowired //inyeccion de dependencias
	private ProfesorRepository profesorRepository;
	
	@GetMapping("profesor")//consulta y devuelve todos los profesors
	private List<ProfesorModel> getAllProfesor() {
		return profesorRepository.findAll();
	}
	
	@GetMapping("/profesor/{ProfesorId}") // consulta y devuelve el empleado por ID
	public ResponseEntity<ProfesorModel> getProfesorId(@PathVariable(value = "ProfesorId") Long ProfesorId)
	         throws ResourceNotFoundException{
		ProfesorModel profesor = profesorRepository.findById(ProfesorId).orElseThrow(()->
		new  ResourceNotFoundException("Profesor no encontrado por ID: " + ProfesorId));
		return ResponseEntity.ok(profesor);
	
	}
	
	@PostMapping("/profesor") // se usa para crear o guardar en base de datos
	public ProfesorModel createProfesor(@Validated @RequestBody ProfesorModel profesor) {
		return profesorRepository.save(profesor);
	}
	
	@PutMapping("/profesor/{ProfesorId}")// se usa para actualizar los profesors
	public  ResponseEntity<ProfesorModel> updateProfesor(@PathVariable(value = "ProfesorId")Long ProfesorId,
			@Validated @RequestBody ProfesorModel profesorDetails) throws ResourceNotFoundException{
		
	ProfesorModel profesor = profesorRepository.findById(ProfesorId)
		.orElseThrow(() -> new ResourceNotFoundException("Profesor no ha sido encontrado por el ID : " + ProfesorId));
	    
	profesor.setNombre(profesorDetails.getNombre());
	profesor.setApellido(profesorDetails.getApellido());
	final ProfesorModel updateProfesor = profesorRepository.save(profesor);
	return ResponseEntity.ok(updateProfesor);
		
	}
	
	@DeleteMapping("/profesor/{ProfesorId}") // se utiliza para la eliminación del profesor por ID
	public Map<String,Boolean> deleteProfesor(@PathVariable(value = "ProfesorId")Long ProfesorId)
	        throws ResourceNotFoundException
	
	{
		ProfesorModel profesor = profesorRepository.findById(ProfesorId)
				.orElseThrow(() -> new ResourceNotFoundException("Profesor no se encuentra el ID :" + ProfesorId));
		 profesorRepository.delete(profesor);
		 Map<String, Boolean> response = new HashMap<>();
		 response.put("delete", Boolean.TRUE);
		 return response;
		
	}

}
