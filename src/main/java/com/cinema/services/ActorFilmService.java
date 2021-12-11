package com.cinema.services;

import com.cinema.repositories.IActorfilmRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorFilmService {
    private IActorfilmRepository actorFilmRepository;

    public ActorFilmService(IActorfilmRepository actorFilmRepository){
        this.actorFilmRepository = actorFilmRepository;
    }
}
