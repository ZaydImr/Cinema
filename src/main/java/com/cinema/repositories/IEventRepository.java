package com.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.events.Event;

import java.util.UUID;

@Repository
public interface IEventRepository extends JpaRepository<Event, UUID> {
}
