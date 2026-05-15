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

import com.duoc.moviemind.model.Pelicula;
import com.duoc.moviemind.service.PeliculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas(){
        System.out.println("[PeliculaController] -> listarPeliculas");
        return ResponseEntity.ok(peliculaService.getPeliculas());
    }

    @PostMapping
    public ResponseEntity<Pelicula> agregarPelicula(@Valid @RequestBody Pelicula pelicula){
        System.out.println("[PeliculaController] -> agregarPelicula");
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.savePelicula(pelicula));
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPelicula(@PathVariable Integer id){
        System.out.println("[PeliculaController] -> buscarPelicula id=" + id);
        Pelicula pelicula = peliculaService.getPeliculaId(id);
        if(pelicula == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Integer id, @Valid @RequestBody Pelicula pelicula){
        System.out.println("[PeliculaController] -> actualizarPelicula id=" + id);
        pelicula.setIdPelicula(id);
        Pelicula actualizado = peliculaService.updatePelicula(pelicula);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Integer id){
        System.out.println("[PeliculaController] -> eliminarPelicula id=" + id);
        peliculaService.deletePelicula(id);
        System.out.println("Pelicula eliminada exitosamente");
        return ResponseEntity.noContent().build();
    }

    


    


    
}
