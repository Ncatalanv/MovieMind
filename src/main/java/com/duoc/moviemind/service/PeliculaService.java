package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.moviemind.model.Pelicula;
import com.duoc.moviemind.repository.PeliculaRepository;

@Service
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
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula updatePelicula(Pelicula pelicula){
        if(!peliculaRepository.existsById(pelicula.getIdPelicula())){
            return null;
        }
        return peliculaRepository.save(pelicula);
    }

    public void deletePelicula(int id){
        peliculaRepository.deleteById(id);
    }


    
}
