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

import com.duoc.moviemind.model.Genero;
import com.duoc.moviemind.service.GeneroService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> listaGenero(){
        return ResponseEntity.ok(generoService.getGeneros());
    }

    @PostMapping
    public ResponseEntity<Genero> agregarGenero(@Valid @RequestBody Genero genero){
        System.out.println("Estoy en el PostMapping y quiero agregar genero");
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.saveGenero(genero));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarGenero(@PathVariable Integer id){
        System.out.println("[GeneroController] -> buscarGenero id=" + id);
        Genero genero = generoService.getGeneroId(id);
        if(genero == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> actualizarGenero(@PathVariable Integer id, @Valid @RequestBody Genero genero){
        genero.setIdGenero(id);
        Genero actualizado = generoService.updateGenero(genero);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGenero(@PathVariable Integer id){
        generoService.deleteGenero(id);
        return ResponseEntity.noContent().build();
    }


}
