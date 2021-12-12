package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Events;
import com.cinema.repositories.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventsService {
    private final IEventRepository eventRepository;

    @Autowired
    public EventsService(IEventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Events addEvent(Events event){
        event.setIdEvent(UUID.fromString(UUID.randomUUID().toString()));
        return (Events) eventRepository.save(event);
    }

    public Events getAllEvents(){
        return (Events) eventRepository.findAll();
    }

    public Events updateEvent(Events event){
        return eventRepository.save(event);
    }

    public Events findEventById(UUID id) throws Throwable {
        return (Events) eventRepository.findEventById(id)
                .orElseThrow(() -> new ElementNotFoundException("Event was not found !"));
    }

    public void deleteEvent(UUID id){
        eventRepository.deleteEventById(id);
    }
}
