package com.duoc.moviemind.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "peliculas")
public class Pelicula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pelicula;

    @NotBlank
    private String tipo;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String genero;

    @NotNull
    private int añoLanzamiento;

    @NotNull
    private int duracion;

    @NotBlank
    private String protagonista;

    @NotNull
    private int valoracion;

    @NotNull
    private int popularidad;

    @OneToMany(mappedBy = "id_pelicula")
    private List<Resena> resena;

    @ManyToMany(mappedBy = "id_pelicula")
    private List<Actor> actor;
}
