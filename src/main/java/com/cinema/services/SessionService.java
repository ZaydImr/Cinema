package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Comment;
import com.cinema.models.Session;
import com.cinema.repositories.ICommentRepository;
import com.cinema.repositories.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService {
    private final ISessionRepository sessionRepository;

    @Autowired
    public SessionService(ISessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Session addSession(Session session){
        session.setIdSession(UUID.fromString(UUID.randomUUID().toString()));
        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }

    public Session updateSession(Session session){
        return sessionRepository.save(session);
    }

    public Session findSessionById(UUID id) throws Throwable {
        return sessionRepository.findSessionById(id)
                .orElseThrow(() -> new ElementNotFoundException("Session was not found !"));
    }

    public void deleteSession(UUID id){
        sessionRepository.deleteCommentById(id);
    }
}
