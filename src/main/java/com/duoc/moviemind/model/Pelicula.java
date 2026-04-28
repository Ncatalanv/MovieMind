package com.duoc.moviemind.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private int idPelicula;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;

    //REVISAR ATRIBUTO GENERO - OBJETO
    @NotBlank
    private Genero genero;

    @NotNull
    private int anoLanzamiento;

    @NotNull
    private int duracion;

    @NotBlank
    @OneToOne
    private Actor actorPrincipal;

    @NotNull
    private int valoracion;

    @NotNull
    private int popularidad;

    @OneToMany(mappedBy = "pelicula")
    private List<Resena> resena = new ArrayList<>();

    //Película es la clase dueña, entonces tengo que quitar el mappedBy acá.
    //Hay que crear una tercera tabla para conectar Pelicula - Actor.
    //Para eso tenemos que crearla con JoinTable, pero Hibernate la crea igual si no la creamos nosotros
    @ManyToMany
    private List<Actor> actor = new ArrayList<>();

    @ManyToMany
    private List<Genero> generos = new ArrayList<>();
}
