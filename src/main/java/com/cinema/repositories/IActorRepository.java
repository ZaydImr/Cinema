package com.cinema.repositories;

import com.cinema.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IActorRepository extends JpaRepository<Actor, UUID> {
    void deleteActorById(UUID id);

    Optional<Actor> findActorById(UUID id);
}
