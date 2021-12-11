package com.cinema.repositories;

import com.cinema.models.FilmImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFilmImageRepository extends JpaRepository<FilmImage, UUID> {
}
