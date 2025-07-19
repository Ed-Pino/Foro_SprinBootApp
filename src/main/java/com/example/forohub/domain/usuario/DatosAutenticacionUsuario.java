package com.example.forohub.domain.usuario;

import com.fasterxml.jackson.annotation.JsonProperty; // <-- AÑADIR IMPORT
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        @Email
        @JsonProperty("email") // Le dice a Jackson que este campo corresponde a la clave "email" del JSON
        String correoElectronico,

        @NotBlank
        @JsonProperty("password") // Le dice a Jackson que este campo corresponde a la clave "password" del JSON
        String contrasena
) {
}