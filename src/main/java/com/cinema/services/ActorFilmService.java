package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.ActorFilm;
import com.cinema.repositories.IActorfilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorFilmService implements IGenericRepository<ActorFilm, UUID> {
    private IActorfilmRepository actorFilmRepository;

    public ActorFilmService(IActorfilmRepository actorFilmRepository){
        this.actorFilmRepository = actorFilmRepository;
    }


    @Override
    public List<ActorFilm> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(ActorFilm obj) {

    }

    @Override
    public void UpdateEntity(ActorFilm obj) {

    }

    @Override
    public ActorFilm GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
