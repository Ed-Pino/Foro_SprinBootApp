package com.example.forohub.domain.topico;

//import jakarta.validation.constraints.NotBlank;

//public record DatosActualizarTopico(
//       @NotBlank String titulo,
//       @NotBlank String mensaje
//) {}


// Nota: No usamos @NotBlank para permitir actualizaciones parciales.
// El usuario puede enviar solo el título o solo el mensaje.
public record DatosActualizarTopico(
        String titulo,
        String mensaje
) {
}