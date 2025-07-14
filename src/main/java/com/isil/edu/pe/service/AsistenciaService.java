package com.isil.edu.pe.service;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.AsistenciaModel;
import com.isil.edu.pe.repository.AsistenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaService(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    public List<AsistenciaModel> obtenerTodasAsistencias() {
        return asistenciaRepository.findAll();
    }

    public AsistenciaModel obtenerAsistenciaPorId(Integer id) throws ResourceNotFoundException {
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con ID: " + id));
    }

    public AsistenciaModel crearAsistencia(AsistenciaModel asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public AsistenciaModel actualizarAsistencia(Integer id, AsistenciaModel asistenciaDetalles) throws ResourceNotFoundException {
        AsistenciaModel asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con ID: " + id));

        asistencia.setUsuario(asistenciaDetalles.getUsuario());
        asistencia.setCursoSalon(asistenciaDetalles.getCursoSalon());
        asistencia.setFecha(asistenciaDetalles.getFecha());
        asistencia.setHoraRegistro(asistenciaDetalles.getHoraRegistro());

        return asistenciaRepository.save(asistencia);
    }

    public void eliminarAsistencia(Integer id) throws ResourceNotFoundException {
        AsistenciaModel asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con ID: " + id));
        
        asistenciaRepository.delete(asistencia);
    }
}