package com.duoc.moviemind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name= "actores")

public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActor;

    @NotBlank
    private String nombre;

    @NotNull
    private Integer edad;

    @NotBlank
    private String nacionalidad;
    
    //@ManyToMany(mappedBy = "actor")
    //private List<Pelicula> pelicula = new ArrayList<>();
}
