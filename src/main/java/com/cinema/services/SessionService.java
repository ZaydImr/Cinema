package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Session;
import com.cinema.repositories.ISessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService implements IGenericRepository<Session, UUID> {
    private ISessionRepository sessionRepository;
    public SessionService(ISessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Session obj) {

    }

    @Override
    public void UpdateEntity(Session obj) {

    }

    @Override
    public Session GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
