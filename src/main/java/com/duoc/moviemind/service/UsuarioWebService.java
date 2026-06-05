package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.moviemind.model.UsuarioWeb;
import com.duoc.moviemind.repository.UsuarioWebRepository;

@Service
public class UsuarioWebService {
    @Autowired
    private UsuarioWebRepository usuarioWebRepository;

    public List<UsuarioWeb> getUsuariosWeb(){
        return usuarioWebRepository.findAll();
    }

    public UsuarioWeb saveUsuarioWeb(UsuarioWeb usuarioweb){
        return usuarioWebRepository.save(usuarioweb);
    }

    public UsuarioWeb getUsuarioWebId(Integer id){
        return usuarioWebRepository.findById(id).orElse(null);
    }

    public UsuarioWeb updateUsuarioWeb(UsuarioWeb usuarioweb){
        if(!usuarioWebRepository.existsById(usuarioweb.getIdUsuario())){
            return null;
        }
        return usuarioWebRepository.save(usuarioweb);
    }

    public void deleteUsuarioWeb(Integer id){
        usuarioWebRepository.deleteById(id);
    }
    
}
