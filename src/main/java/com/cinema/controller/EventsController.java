package com.cinema.controller;

import com.cinema.services.EventsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventsController {
    private final EventsService eventsService;
    public EventsController(EventsService eventsService){
        this.eventsService = eventsService;
    }
}
