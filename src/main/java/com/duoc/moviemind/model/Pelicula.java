package com.duoc.moviemind.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
//@AllArgsConstructor
@Entity
@Table(name= "peliculas")
public class Pelicula {

    //Borré el NoArgsConstructor por un error
    public Pelicula() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPelicula;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;

    //REVISAR ATRIBUTO GENERO - OBJETO
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero generoPrincipal;

    @NotNull
    private Integer anoLanzamiento;

    @NotNull
    private Integer duracion;

    @NotNull
    @ManyToOne
    @JoinColumn(name= "id_actor_principal")
    private Actor actorPrincipal;

    @NotNull
    private Integer valoracion;

    @NotNull
    private Integer popularidad;

    @OneToMany(mappedBy = "pelicula")
    // Al traer las resenas, no repetirán la película de dentro
    @JsonIgnoreProperties("pelicula")
    private List<Resena> resena = new ArrayList<>();



    //Película es la clase dueña, entonces tengo que quitar el mappedBy acá.
    //Hay que crear una tercera tabla para conectar Pelicula - Actor.
    //Para eso tenemos que crearla con JoinTable, pero Hibernate la crea igual si no la creamos nosotros
    //@OneToMany
    //private List<Actor> actor = new ArrayList<>();

    //@ManyToOne
    //@JoinColumn(name = "id_genero")
    //private Genero genero;
}
