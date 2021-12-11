package com.cinema.services;

import com.cinema.repositories.ISessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private ISessionRepository sessionRepository;
    public SessionService(ISessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }
}
