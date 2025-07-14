package com.isil.edu.pe.service;

import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.CursoModel;
import com.isil.edu.pe.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoModel> obtenerTodosCursos() {
        return cursoRepository.findAll();
    }

    public CursoModel obtenerCursoPorId(Integer id) throws ResourceNotFoundException {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));
    }

    public CursoModel crearCurso(CursoModel curso) {
        return cursoRepository.save(curso);
    }

    public CursoModel actualizarCurso(Integer id, CursoModel cursoDetalles) throws ResourceNotFoundException {
        CursoModel curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));

        curso.setNombreCurso(cursoDetalles.getNombreCurso());

        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Integer id) throws ResourceNotFoundException {
        CursoModel curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));
        cursoRepository.delete(curso);
    }
}