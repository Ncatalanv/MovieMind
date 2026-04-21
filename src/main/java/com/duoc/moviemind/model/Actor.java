package com.duoc.moviemind.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private int id_actor;

    @NotNull
    private int nombre;

    @NotNull
    private int edad;

    @NotBlank
    private String nacionalidad;
    
    @ManyToMany(mappedBy = "id_actor")
    private List<Pelicula> pelicula;
}
