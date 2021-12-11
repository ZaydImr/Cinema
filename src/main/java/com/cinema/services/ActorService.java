package com.cinema.services;

import com.cinema.repositories.IActorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private IActorRepository actorRepository;
    public ActorService(IActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
}
