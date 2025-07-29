package com.example.forohub.controller;

import com.example.forohub.domain.respuesta.DatosActualizarRespuesta;
import com.example.forohub.domain.respuesta.DatosDetalleRespuesta;
import com.example.forohub.domain.respuesta.RespuestaRepository;
import com.example.forohub.domain.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleRespuesta> actualizarRespuesta(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarRespuesta datos) {

        // 1. Buscamos la respuesta en la base de datos
        var respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Respuesta no encontrada con ID: " + id));

        // 2. OBTENEMOS AL USUARIO AUTENTICADO
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioAutenticado = (Usuario) authentication.getPrincipal();

        // 3. VALIDAMOS LA AUTORÍA
        if (!respuesta.getAutor().getId().equals(usuarioAutenticado.getId())) {
            // Si el ID del autor de la respuesta no es el mismo que el del usuario logueado, denegamos el acceso.
            // En un futuro, aquí podríamos añadir una comprobación de si es un ADMIN.
            return ResponseEntity.status(403).build(); // 403 Forbidden
        }

        // 4. Actualizamos el mensaje
        respuesta.actualizarMensaje(datos.mensaje());

        // 5. Devolvemos la respuesta actualizada
        return ResponseEntity.ok(new DatosDetalleRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id) {
        // 1. Buscamos la respuesta
        var respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Respuesta no encontrada con ID: " + id));

        // 2. Obtenemos al usuario autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioAutenticado = (Usuario) authentication.getPrincipal();

        // 3. VALIDAMOS LA AUTORÍA (exactamente la misma lógica que en PUT)
        if (!respuesta.getAutor().getId().equals(usuarioAutenticado.getId())) {
            return ResponseEntity.status(403).build(); // Forbidden
        }

        // 4. Ejecutamos el borrado físico
        respuestaRepository.delete(respuesta);

        // 5. Devolvemos la respuesta estándar para una eliminación exitosa
        return ResponseEntity.noContent().build();
    }
}