package com.cinema.repositories;

import com.cinema.models.Film;
import com.cinema.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISessionRepository extends JpaRepository<Session, UUID> {
    @Query("SELECT s FROM Session s WHERE s.film.titleFilm LIKE %?1%")
    List<Session> getAllByKeyword(String keyword);
}
