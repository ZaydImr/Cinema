package com.cinema.controller;

import com.cinema.services.ActorFilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actorfilm")
public class ActorFilmController {
    private ActorFilmService actorFilmService;
    public ActorFilmController(ActorFilmService actorFilmService){
        this.actorFilmService = actorFilmService;
    }
}
