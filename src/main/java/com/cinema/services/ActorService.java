package com.cinema.services;


import com.cinema.models.Actor;
import com.cinema.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class ActorService extends AbstractService<Actor,UUID> {

    @Autowired
    private IActorRepository actorRepository;

    @Override
    protected JpaRepository<Actor, UUID> getRepository() {
        return actorRepository;
    }

    /*@Override
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
    }*/
}
