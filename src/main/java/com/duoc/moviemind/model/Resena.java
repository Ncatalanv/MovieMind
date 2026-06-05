package com.duoc.moviemind.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer idResena;

    @NotNull
    private Integer valoracion;

    @NotBlank
    private String descripcion;

    @NotNull
    private Integer fechaResena;

    // En ManyToOne no se usa "mappedBy". Se usa "JoinColumn"
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    // Traerá la película, pero ignorará la lista resena que está dentro
    @JsonIgnoreProperties("resena")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "id_usuarioweb")
    @JsonIgnoreProperties("resena")
    private UsuarioWeb usuarioWeb;

}
