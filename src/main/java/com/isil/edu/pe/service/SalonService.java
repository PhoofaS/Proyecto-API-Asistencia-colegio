package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.SalonModel;
import com.isil.edu.pe.repository.SalonRepository;

@Service
public class SalonService {
	
	private final SalonRepository salonRepository;
	
	@Autowired
	public SalonService(SalonRepository salonRepository) {
		this.salonRepository = salonRepository;
	}
	
	public List<SalonModel> obtenerTodosSalones() {
		return salonRepository.findAll();
	}
	
	public SalonModel obtenerSalonPorId(Long id) {
		return salonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado con ID: " + id));
	}
	
	public SalonModel crearSalon(SalonModel salon) {
		return salonRepository.save(salon);
	}
	
	public SalonModel actualizarSalon(Long id, SalonModel salonDetalles) {
		SalonModel salon = salonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado con ID: " + id));
		
		salon.setNombre(salonDetalles.getNombre());
		
		return salonRepository.save(salon);
	}
	public void eliminarSalon(Long id) {
		SalonModel salon = salonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado con ID :" + id));
		salonRepository.delete(salon);
	}

}
