package com.example.forohub.domain.topico;

import com.example.forohub.domain.curso.Curso;
import com.example.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public void actualizarDatos(String nuevoTitulo, String nuevoMensaje) {
        this.titulo = nuevoTitulo;
        this.mensaje = nuevoMensaje;
    }

    // ----- ÚNICO CONSTRUCTOR NECESARIO -----
    // Este es el constructor que usa el controlador para crear nuevos tópicos.
    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now(); // Asignamos la fecha actual por defecto
        this.status = "ABIERTO"; // Asignamos un estado inicial como String
    }

    public void actualizarInformacion(DatosActualizarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
    }

    public void cerrar() {
        this.status = "CERRADO";
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }
}