package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AlumnoModel;
import com.isil.edu.pe.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	private final AlumnoRepository alumnoRepository;
	
	@Autowired
	public AlumnoService(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}
	
	public List<AlumnoModel> obtenerTodosAlumnos() {
		return alumnoRepository.findAll();
	}
	
	public AlumnoModel obtenerAlumnoPorId(Long id) {
		return alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));
	}
	
	public AlumnoModel crearAlumno(AlumnoModel alumno) {
		return alumnoRepository.save(alumno);
	}
	
	public AlumnoModel actualizarAlumno(Long id, AlumnoModel alumnoDetalles) {
		AlumnoModel alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));
		
		alumno.setUsuarioId(alumnoDetalles.getUsuarioId());
		alumno.setNombre(alumnoDetalles.getNombre());
		alumno.setApellido(alumnoDetalles.getApellido());
		
		return alumnoRepository.save(alumno);
	}
	public void eliminarAlumno(Long id) {
		AlumnoModel alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID :" + id));
		alumnoRepository.delete(alumno);
	}
	

}
