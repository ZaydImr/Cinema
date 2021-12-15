package com.cinema.services;

import com.cinema.models.Session;
import com.cinema.repositories.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService extends AbstractService<Session, UUID> {

    @Autowired
    private ISessionRepository sessionRepository;

    @Override
    protected JpaRepository<Session, UUID> getRepository() {
        return sessionRepository;
    }

    /*@Override
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
    }*/
}
