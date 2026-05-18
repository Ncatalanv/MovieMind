package com.duoc.moviemind.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Se activa cuando @Valid falla → 400 Bad Request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApp> handleValidationErrors(MethodArgumentNotValidException ex) {
        String detalle = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest()
                .body(new ErrorApp(400, "Error de validación", detalle));
    }

    // Se activa ante cualquier excepción no esperada → 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApp> handleGenericError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorApp(500, "Error interno del servidor", ex.getMessage()));
    }

    // Maneja errores de la API externa (Open Library) → 404 o 502
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorApp> handleWebClientError(WebClientResponseException ex) {
        if (ex.getStatusCode().value() == 404) {
            ErrorApp error = new ErrorApp(404, "ISBN no encontrado en Open Library", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        ErrorApp error = new ErrorApp(502, "Error al consultar Open Library", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
    }

}
