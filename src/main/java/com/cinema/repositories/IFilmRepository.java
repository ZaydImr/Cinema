package com.cinema.repositories;

import com.cinema.models.Actor;
import com.cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IFilmRepository extends JpaRepository<Film, UUID> {
    @Query("SELECT d FROM Film d WHERE d.titleFilm LIKE %?1%")
    List<Film> getAllByKeyword(String keyword);
}
