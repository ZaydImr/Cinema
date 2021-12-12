package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Actor;
import com.cinema.repositories.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService implements IGenericRepository<Actor, UUID> {
    private IActorRepository actorRepository;
    public ActorService(IActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }


    @Override
    public List<Actor> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Actor obj) {

    }

    @Override
    public void UpdateEntity(Actor obj) {

    }

    @Override
    public Actor GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
