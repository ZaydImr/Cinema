package com.cinema.services;


import com.cinema.dao.IGenericRepository;
import com.cinema.models.Actor;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService implements IGenericRepository<Actor, UUID> {
    private final IActorRepository actorRepository;

    @Autowired
    public ActorService(IActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> GetAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor AddEntity(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor UpdateEntity(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor GetOneById(UUID id) {
        return (Actor) actorRepository.findActorById(id)
                .orElseThrow(() -> new ElementNotFoundException("Actor was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        actorRepository.deleteActorById(id);
    }
}
