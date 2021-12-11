package com.cinema.services;

import com.cinema.repositories.IEventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventsService {
    private IEventRepository eventRepository;
    public EventsService(IEventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
}
