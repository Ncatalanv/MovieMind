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

import com.duoc.moviemind.model.Resena;
import com.duoc.moviemind.service.ResenaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/resenas")
public class ResenaController {

    @Autowired
    ResenaService resenaService;

    @GetMapping
    public ResponseEntity<List<Resena>> listaResenas(){
        return ResponseEntity.ok(resenaService.getResena());
    }

    @PostMapping
    public ResponseEntity<Resena> agregarResena(@Valid @RequestBody Resena resena){
        System.out.println("Estoy en el PostMapping y quiero agregar una resena");
        return ResponseEntity.status(HttpStatus.CREATED).body(resenaService.saveResena(resena));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> buscarResena(@PathVariable Integer id){
        System.out.println("[ResenaController] -> buscarResena id=" + id);
        Resena resena = resenaService.getResenaId(id);
        if(resena == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable Integer id, @Valid @RequestBody Resena resena){
        resena.setIdResena(id);
        Resena actualizado = resenaService.updateResena(resena);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Integer id){
        resenaService.deleteResena(id);
        return ResponseEntity.noContent().build();
    }

}
