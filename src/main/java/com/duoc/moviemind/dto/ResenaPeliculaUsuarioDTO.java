package com.duoc.moviemind.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResenaPeliculaUsuarioDTO {
    private String titulo;
    private String descripcion;
    private String nombreUsuarioWeb;
    
}
