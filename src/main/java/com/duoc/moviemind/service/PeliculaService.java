package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.duoc.moviemind.model.Pelicula;
import com.duoc.moviemind.repository.PeliculaRepository;

public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getPeliculas(){
        return peliculaRepository.findAll();
    }

    public Pelicula savePelicula(Pelicula pelicula){
        return peliculaRepository.save(pelicula);
    }

    public Pelicula getPeliculaId(int id){
        return peliculaRepository.find

    }


    
}
