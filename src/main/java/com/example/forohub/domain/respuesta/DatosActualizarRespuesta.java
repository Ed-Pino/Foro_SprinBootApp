package com.example.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarRespuesta(
        @NotBlank
        String mensaje
) {
}