package com.cinema.repositories;

import com.cinema.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.events.Event;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IEventRepository extends JpaRepository<Events, UUID> {
    void deleteEventById(UUID id);

    Optional<Events> findEventById(UUID id);
}
