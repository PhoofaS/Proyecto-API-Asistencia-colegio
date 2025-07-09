package com.isil.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.SalonModel;
import com.isil.edu.pe.repository.SalonRepository;

@Service
public class SalonService {
	
	private final SalonRepository salonRepository;
	
	public SalonService(SalonRepository salonRepository) {
		this.salonRepository = salonRepository;
	}
	
	public List<SalonModel> obtenerTodosSalones() {
		return salonRepository.findAll();
	}
	
	public SalonModel obtenerSalonPorId(Long id) throws ResourceNotFoundException {
		return salonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado con ID: " + id));
	}
	
	public SalonModel crearSalon(SalonModel salon) {
		return salonRepository.save(salon);
	}
	
	public SalonModel actualizarSalon(Long id, SalonModel salonDetalles) throws ResourceNotFoundException {
		SalonModel salon = salonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado con ID: " + id));
		
		salon.setNombreSalon(salonDetalles.getNombreSalon());
		
		return salonRepository.save(salon);
	}
	public void eliminarSalon(Long id) throws ResourceNotFoundException {
		SalonModel salon = salonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado con ID :" + id));
		salonRepository.delete(salon);
	}

}
