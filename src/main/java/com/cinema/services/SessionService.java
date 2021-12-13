package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Session;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class SessionService implements IGenericRepository<Session, UUID> {
    private ISessionRepository sessionRepository;

    @Autowired
    public SessionService(ISessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> GetAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session AddEntity(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session UpdateEntity(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session GetOneById(UUID id) {
        return sessionRepository.findSessionById(id)
                .orElseThrow(() -> new ElementNotFoundException("Session was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        sessionRepository.deleteCommentById(id);
    }
}
