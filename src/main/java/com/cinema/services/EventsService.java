package com.cinema.services;


import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Events;
import com.cinema.repositories.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EventsService implements IGenericRepository<Events, UUID> {
    private final IEventRepository eventRepository;

    @Autowired
    public EventsService(IEventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> GetAll() {
        return eventRepository.findAll();
    }

    @Override
    public Events AddEntity(Events event) {
        return eventRepository.save(event);
    }

    @Override
    public Events UpdateEntity(Events event) {
        return eventRepository.save(event);
    }

    @Override
    public Events GetOneById(UUID id) {
        return (Events) eventRepository.findEventById(id)
                .orElseThrow(() -> new ElementNotFoundException("Event was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        eventRepository.deleteEventById(id);
    }
}
