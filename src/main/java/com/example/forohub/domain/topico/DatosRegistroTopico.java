package com.example.forohub.domain.topico;

import com.fasterxml.jackson.annotation.JsonProperty; // <-- AÑADIR IMPORT
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        @JsonProperty("id_usuario") // Mapea el campo "id_usuario" del JSON a este campo
        Long autorId,

        @NotNull
        @JsonProperty("id_curso") // Mapea el campo "id_curso" del JSON a este campo
        Long cursoId
) {
}