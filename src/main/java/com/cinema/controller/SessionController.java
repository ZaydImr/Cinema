package com.cinema.controller;

import com.cinema.services.SessionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    private SessionService sessionService;
    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }
}
