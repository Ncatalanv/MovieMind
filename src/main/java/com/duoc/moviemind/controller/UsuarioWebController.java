package com.duoc.moviemind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.moviemind.model.UsuarioWeb;
import com.duoc.moviemind.service.UsuarioWebService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1/usuariosweb")
public class UsuarioWebController {

    @Autowired
    UsuarioWebService usuarioWebService;

    @GetMapping
    public ResponseEntity<List<UsuarioWeb>> listaUsuariosWeb(){
        System.out.println("[UsuarioWebController] -> listarUsuariosWeb");
        return ResponseEntity.ok(usuarioWebService.getUsuariosWeb());
    }

    @PostMapping
    public ResponseEntity<UsuarioWeb> agregarUsuarioWeb(@Valid @RequestBody UsuarioWeb usuarioweb){
        System.out.println("[UsuarioWebController] -> agregarUsuariosWeb");
        //System.out.println("Estoy en el PostMapping y quiero agregar un usuario");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioWebService.saveUsuarioWeb(usuarioweb));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioWeb> buscarUsuarioWeb(@PathVariable Integer id){
        System.out.println("[UsuarioWebController] -> buscarUsuarioWeb id=" + id);
        UsuarioWeb usuarioweb = usuarioWebService.getUsuarioWebId(id);
        if(usuarioweb == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioweb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioWeb> actualizarUsuarioWeb(@PathVariable Integer id, @Valid @RequestBody UsuarioWeb usuarioweb){
        System.out.println("[UsuarioWebController] -> actualizarUsuarioWeb id=" + id);
        usuarioweb.setIdUsuario(id);
        UsuarioWeb actualizado = usuarioWebService.updateUsuarioWeb(usuarioweb);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioWeb(@PathVariable Integer id){
        System.out.println("[UsuarioWebController] -> eliminarUsuarioWeb id=" + id);
        usuarioWebService.deleteUsuarioWeb(id);
        return ResponseEntity.noContent().build();
    }

}

