package com.example.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {
    // Este constructor mapea una entidad Topico a este DTO
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus().toString(), // Asumiendo que status es un Enum
                topico.getAutor().getNombre(), // Asumiendo que la entidad Usuario tiene un método getNombre()
                topico.getCurso().getNombre()  // Asumiendo que la entidad Curso tiene un método getNombre()
        );
    }
}