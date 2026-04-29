package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.moviemind.model.Genero;
import com.duoc.moviemind.repository.GeneroRepository;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getGeneros(){
        return generoRepository.findAll();
    }

    public Genero saveGenero(Genero genero){
        return generoRepository.save(genero);
    }

    public Genero getGeneroId(int id){
        return generoRepository.findById(id).orElse(null);
    }

    public Genero updateGenero(Genero genero){
        if (!generoRepository.existsById(genero.getIdGenero())){
            return null;
        }
        return generoRepository.save(genero);
    }

    public void deleteGenero(int id){
        generoRepository.deleteById(id);
    }


}
