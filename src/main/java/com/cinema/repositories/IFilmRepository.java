package com.cinema.repositories;

import com.cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IFilmRepository extends JpaRepository<Film, UUID> {

    Optional<Film> findFilmById(UUID id);

    void deleteFilmById(UUID id);
}
