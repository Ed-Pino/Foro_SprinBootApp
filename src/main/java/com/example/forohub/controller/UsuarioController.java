package com.example.forohub.controller;

import com.example.forohub.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectamos el codificador

    @Autowired
    private PerfilRepository perfilRepository;


    // ... (dentro de la clase UsuarioController)

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleUsuario> registrarUsuario(
            @RequestBody @Valid DatosRegistroUsuario datosRegistro,
            UriComponentsBuilder uriBuilder) {

        // 1. Buscar el perfil por defecto "ROLE_USER"
        var perfilUsuario = perfilRepository.findByNombre("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Error: Perfil ROLE_USER no encontrado en la base de datos."));

        // 2. Codificar la contraseña
        var contrasenaHasheada = passwordEncoder.encode(datosRegistro.contrasena());

        // 3. Crear la entidad Usuario usando el constructor que acepta perfiles
        // ----- LÍNEA CORREGIDA -----
        var usuario = new Usuario(datosRegistro, contrasenaHasheada, Set.of(perfilUsuario));

        // 4. Guardar el nuevo usuario en la base de datos
        usuarioRepository.save(usuario);

        // 5. Crear la URI para la cabecera Location
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        // 6. Devolver la respuesta
        return ResponseEntity.created(uri).body(new DatosDetalleUsuario(usuario));
    }
}