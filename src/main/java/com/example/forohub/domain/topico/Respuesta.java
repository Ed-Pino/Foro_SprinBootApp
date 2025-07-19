// CÓDIGO MEJORADO Y CORRECTO PARA Respuesta.java
package com.example.forohub.domain.topico;

import com.example.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "respuesta") // Es buena práctica añadir @Table también
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    // Campo corregido para evitar el mapeo duplicado
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private boolean solucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
}