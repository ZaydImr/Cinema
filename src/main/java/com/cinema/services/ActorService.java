package com.cinema.services;


import com.cinema.models.Actor;
import com.cinema.models.Director;
import com.cinema.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class ActorService extends AbstractService<Actor,UUID> {

    @Autowired
    private IActorRepository actorRepository;

    @Override
    protected JpaRepository<Actor, UUID> getRepository() {
        return actorRepository;
    }

    public List<Actor> GetAllByKeyword(String keyword) {
        return actorRepository.getAllByKeyword(keyword);
    }
}
