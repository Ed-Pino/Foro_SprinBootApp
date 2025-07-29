package com.example.forohub.domain.respuesta;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,

        @NotNull
        @JsonProperty("id_usuario")
        Long autorId
) {
}