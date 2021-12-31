package com.cinema.repositories;

import com.cinema.models.FilmImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IFilmImageRepository extends JpaRepository<FilmImage, UUID> {

    @Query("select fi.imageUrl from FilmImage fi where fi.film.id = ?1")
    List<String> getImageUrlByFilmId(UUID id);
}
