package com.isil.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.isil.edu.pe.exceptions.ResourceNotFoundException;
import com.isil.edu.pe.model.UsuarioModel;
import com.isil.edu.pe.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioModel> obtenerTodosUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public UsuarioModel obtenerUsuarioPorId(Integer id) throws ResourceNotFoundException {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
	}
	
	public UsuarioModel crearUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioDetalles) throws ResourceNotFoundException {
		UsuarioModel usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
		
		usuario.setDocumentoIdentidad(usuarioDetalles.getDocumentoIdentidad());
		usuario.setNombreCompleto(usuarioDetalles.getNombreCompleto());
		usuario.setContrasena(usuarioDetalles.getContrasena());
		usuario.setEsAdministrador(usuarioDetalles.getEsAdministrador());
		
		return usuarioRepository.save(usuario);
	}
	public void eliminarUsuario(Integer id) throws ResourceNotFoundException {
		UsuarioModel usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID :" + id));
		usuarioRepository.delete(usuario);
	}

}
