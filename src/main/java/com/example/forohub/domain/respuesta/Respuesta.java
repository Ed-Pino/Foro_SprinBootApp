package com.example.forohub.domain.respuesta;

import com.example.forohub.domain.topico.Topico;
import com.example.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter; // Asegúrate de que este import está
import lombok.NoArgsConstructor;
import lombok.Setter; // Asegúrate de que este import está
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuesta")
@Getter // Asegúrate de que esta anotación esté aquí
@Setter // Asegúrate de que esta anotación esté aquí
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private Boolean solucion;

    private Boolean activo; // Campo añadido y corregido el typo 'activi'

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    // Constructor para la creación de nuevas respuestas (modificado para activo=true)
    public Respuesta(String mensaje, Topico topico, Usuario autor) {
        this.mensaje = mensaje;
        this.topico = topico;
        this.autor = autor;
        this.fechaCreacion = LocalDateTime.now();
        this.solucion = false;
        this.activo = true; // Inicialización añadida
    }

    // Método para la actualización
    public void actualizarMensaje(String nuevoMensaje) {
        if (nuevoMensaje != null) {
            this.mensaje = nuevoMensaje;
        }
    }

    // Método para el borrado lógico
    public void desactivar() {
        this.activo = false;
    }

    // ----- GETTERS EXPLÍCITOS AÑADIDOS PARA TODOS LOS CAMPOS -----
    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Topico getTopico() {
        return topico;
    }

    public Usuario getAutor() {
        return autor;
    }
    // -------------------------------------------------------------
}