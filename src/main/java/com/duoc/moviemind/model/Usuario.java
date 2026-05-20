package com.duoc.moviemind.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
//@AllArgsConstructor
@Entity
@Table(name= "usuarios")
public class Usuario {
    
    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotBlank
    private String nombreUsuario;

    @NotBlank
    private String correo;

    //Un usuario puede tener muchas reseñas, entonces necesito una lista para guardarlo 
    @OneToMany(mappedBy="usuario")
    @JsonIgnore
    private List<Resena> resena = new ArrayList<>();

}
