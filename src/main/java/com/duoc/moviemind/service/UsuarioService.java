package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.moviemind.model.Usuario;
import com.duoc.moviemind.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioId(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario usuario){
        if(!usuarioRepository.existsById(usuario.getIdUsuario())){
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }
    
}
