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

import com.duoc.moviemind.model.Actor;
import com.duoc.moviemind.service.ActorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/actores")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> listarActores(){
        return ResponseEntity.ok(actorService.getActores());
    }

    @PostMapping
    public ResponseEntity<Actor> agregarActor(@Valid @RequestBody Actor actor){
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.saveActor(actor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> buscarActor(@PathVariable int id){
        System.out.println("[ActorController] -> buscarActor id=" + id);
        Actor actor = actorService.getActorId(id);
        if(actor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> actualizarActor(@PathVariable int id, @Valid @RequestBody Actor actor){
        actor.setIdActor(id);
        Actor actualizado = actorService.updateActor(actor);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarActor(@PathVariable int id){
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }

    

    
    
}
