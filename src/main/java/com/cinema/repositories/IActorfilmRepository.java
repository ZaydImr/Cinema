package com.cinema.repositories;

import com.cinema.models.ActorFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IActorfilmRepository extends JpaRepository<ActorFilm, UUID> {
}
