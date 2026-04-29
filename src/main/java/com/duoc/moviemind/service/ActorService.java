package com.duoc.moviemind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.moviemind.model.Actor;
import com.duoc.moviemind.repository.ActorRepository;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getActores(){
        return actorRepository.findAll();
    }

    public Actor saveActor(Actor actor){
        return actorRepository.save(actor);
    }

    public Actor getActorId(int id){
        return actorRepository.findById(id).orElse(null);

    }

     public Actor updatePelicula(Actor actor){
        if(!actorRepository.existsById(actor.getIdActor())){
            return null;
        }
        return actorRepository.save(actor);
    }

    public void deleteActor(int id){
        actorRepository.deleteById(id);
    }


}
