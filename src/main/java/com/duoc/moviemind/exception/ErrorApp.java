package com.duoc.moviemind.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorApp {

    private int codigo; // Código http númerico (400,500)
    private String mensaje; //Descripción corta del error
    private String detalle; // Información técnica


    //Entonces, cuando la app falle devolverá este JSON en vez de un mensaje de texto plano:
    // {
    // "codigo": 400,
    // "mensaje": "Error de validación",
    // "detalle": "nombre: no debe estar vacío, edad: no debe ser nulo"
    // }
}
