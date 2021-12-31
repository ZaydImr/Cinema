package com.cinema.services;


import com.cinema.models.ActorFilm;
import com.cinema.repositories.IActorfilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

//@Service
public class ActorFilmService /*extends AbstractService<ActorFilm, UUID>*/ {

   /* @Autowired
    private IActorfilmRepository actorFilmRepository;

    @Override
    protected JpaRepository<ActorFilm, UUID> getRepository() {
        return actorFilmRepository;
    }*/
}
