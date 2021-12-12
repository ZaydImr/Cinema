package com.cinema.repositories;

import com.cinema.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISessionRepository extends JpaRepository<Session, UUID> {
    Optional<Session> findSessionById(UUID id);

    void deleteCommentById(UUID id);
}
