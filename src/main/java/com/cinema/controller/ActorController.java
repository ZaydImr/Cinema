package com.cinema.controller;

import com.cinema.services.ActorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }
}
