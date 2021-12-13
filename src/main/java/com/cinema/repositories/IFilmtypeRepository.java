package com.cinema.repositories;

import com.cinema.models.FilmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IFilmtypeRepository extends JpaRepository<FilmType, UUID> {
    Optional<FilmType> findFilmTypeById(UUID id);

    void deleteFilmTypeById(UUID id);
}
