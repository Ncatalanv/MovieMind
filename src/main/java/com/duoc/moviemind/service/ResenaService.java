package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.moviemind.dto.ResenaPeliculaUsuarioDTO;
import com.duoc.moviemind.model.Resena;
import com.duoc.moviemind.repository.ResenaRepository;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> getResena(){
        return resenaRepository.findAll();
    }

    public Resena saveResena(Resena resena){
        return resenaRepository.save(resena);
    }

    public Resena getResenaId(Integer id){
        return resenaRepository.findById(id).orElse(null);
    }

    public Resena updateResena(Resena resena){
        if(!resenaRepository.existsById(resena.getIdResena())){
            return null;
        }
        return resenaRepository.save(resena);
    }

    public void deleteResena(Integer id){
        resenaRepository.deleteById(id);
    }

    public List<ResenaPeliculaUsuarioDTO> getResenaPeliculaUsuario() {
        return resenaRepository.findAll().stream()
                .map(l -> new ResenaPeliculaUsuarioDTO(
                        l.getDescripcion(),
                        l.getPelicula().getTitulo(),
                        l.getUsuario().getNombreUsuario()
                ))
                .toList();
    }
    
}
