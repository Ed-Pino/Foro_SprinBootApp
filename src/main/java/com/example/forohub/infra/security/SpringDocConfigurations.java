package com.example.forohub.infra.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

// CORTAR TODO ESTO DEL ARCHIVO SecurityConfigurations.java
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ForoHub API",
                version = "1.0",
                description = "Documentación de la API Rest de ForoHub"
        )
)
@SecurityScheme(
        name = "bearer-key", // El nombre del esquema de seguridad que usarán los controladores
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SpringDocConfigurations {

}