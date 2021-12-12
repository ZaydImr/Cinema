package com.cinema.services;


import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Actor;

import com.cinema.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService {
    private final IActorRepository actorRepository;

    @Autowired
    public ActorService(IActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public Actor addActor(Actor actor){
        actor.setIdActor(UUID.fromString(UUID.randomUUID().toString()));
        return actorRepository.save(actor);
    }

    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    public Actor updateActor(Actor actor){
        return actorRepository.save(actor);
    }

    public Actor findActorById(UUID id) throws Throwable {
        return (Actor) actorRepository.findActorById(id)
                .orElseThrow(() -> new ElementNotFoundException("Actor was not found !"));
    }

    public void deleteActor(UUID id){
        actorRepository.deleteActorById(id);
    }
}
