package com.example.forohub.controller;

import com.example.forohub.domain.curso.CursoRepository;
import com.example.forohub.domain.topico.*;
import com.example.forohub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        var paginaDeTopicos = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return ResponseEntity.ok(paginaDeTopicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriBuilder) {
        var autor = usuarioRepository.findById(datosRegistroTopico.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado con ID: " + datosRegistroTopico.autorId()));
        var curso = cursoRepository.findById(datosRegistroTopico.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con ID: " + datosRegistroTopico.cursoId()));

        var topico = new Topico(
                datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje(),
                autor,
                curso
        );

        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        var datosDetalle = new DatosDetalleTopico(topico);

        return ResponseEntity.created(uri).body(datosDetalle);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        // 1. Buscamos el tópico en la base de datos
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con ID: " + id));

        // 2. Actualizamos los datos del tópico
        // Creamos un método en la entidad para encapsular esta lógica
        topico.actualizarInformacion(datosActualizarTopico);

        // 3. Devolvemos el DTO con la información actualizada
        // No es necesario llamar a topicoRepository.save(), @Transactional se encarga de persistir los cambios al finalizar el método.
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        // 1. Buscamos el tópico por su ID
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con ID: " + id));

        // 2. Ejecutamos el borrado lógico
        topico.cerrar();

        // 3. Devolvemos la respuesta estándar para una eliminación exitosa
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallarTopico(@PathVariable Long id) {
        // Buscamos el tópico en el repositorio por el ID recibido en la URL
        var topico = topicoRepository.findById(id);

        // Verificamos si el tópico fue encontrado
        if (topico.isPresent()) {
            // Si existe, creamos el DTO de detalle y lo devolvemos con un 200 OK
            var datosDetalle = new DatosDetalleTopico(topico.get());
            return ResponseEntity.ok(datosDetalle);
        } else {
            // Si no existe, devolvemos un 404 Not Found, que es el estándar REST para este caso
            return ResponseEntity.notFound().build();
        }
    }

}