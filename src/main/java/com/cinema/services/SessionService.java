package com.cinema.services;

import com.cinema.models.Film;
import com.cinema.models.Session;
import com.cinema.repositories.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService extends AbstractService<Session, UUID> {

    @Autowired
    private ISessionRepository sessionRepository;

    @Override
    protected JpaRepository<Session, UUID> getRepository() {
        return sessionRepository;
    }

    public List<Session> GetAllByKeyword(String keyword) {
        return sessionRepository.getAllByKeyword(keyword);
    }

}
