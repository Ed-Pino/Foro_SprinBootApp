package com.example.forohub.infra.excepciones;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErrores {

    // Este método se activará cuando JPA no encuentre una entidad (ej. findById)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarError404() {
        // Devuelve una respuesta 404 Not Found vacía
        return ResponseEntity.notFound().build();
    }

    // Este método se activará cuando las validaciones (@Valid) fallen en un DTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DatosErrorValidacion>> tratarError400(MethodArgumentNotValidException e) {
        // Obtenemos todos los errores de campo
        var errores = e.getFieldErrors().stream()
                .map(DatosErrorValidacion::new)
                .toList();
        // Devolvemos una respuesta 400 Bad Request con la lista de errores
        return ResponseEntity.badRequest().body(errores);
    }

    // DTO para formatear la respuesta de error de validación
    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}