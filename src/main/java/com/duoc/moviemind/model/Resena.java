package com.duoc.moviemind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name= "resenas")


public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resena;

    @NotNull
    private int valoracion;

    @NotBlank
    private String descripcion;

    @OneToOne(mappedBy = "id_resena")
    private Pelicula pelicula;
}
