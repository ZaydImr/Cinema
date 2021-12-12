package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Events;
import com.cinema.repositories.IEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventsService implements IGenericRepository<Events, UUID> {
    private IEventRepository eventRepository;
    public EventsService(IEventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Events obj) {

    }

    @Override
    public void UpdateEntity(Events obj) {

    }

    @Override
    public Events GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
