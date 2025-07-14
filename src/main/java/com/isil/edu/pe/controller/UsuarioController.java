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
import com.isil.edu.pe.model.UsuarioModel;
import com.isil.edu.pe.repository.UsuarioRepository;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List<UsuarioModel> getAllUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        System.out.println("Usuarios encontrados: " + usuarios.size());
        return usuarios;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + id));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario")
    public UsuarioModel createUsuario(@Validated @RequestBody UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Integer id,
            @Validated @RequestBody UsuarioModel usuarioDetails) throws ResourceNotFoundException {

        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + id));

        usuario.setDocumentoIdentidad(usuarioDetails.getDocumentoIdentidad());
        usuario.setNombreCompleto(usuarioDetails.getNombreCompleto());
        usuario.setContrasena(usuarioDetails.getContrasena());
        usuario.setEsAdministrador(usuarioDetails.getEsAdministrador());

        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }


    @DeleteMapping("/usuario/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable Integer id) throws ResourceNotFoundException {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + id));
        usuarioRepository.delete(usuario);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
