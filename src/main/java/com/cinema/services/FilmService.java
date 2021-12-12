package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Film;
import com.cinema.repositories.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService {
    private final IFilmRepository filmRepository;

    @Autowired
    public FilmService(IFilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public Film addFilm(Film film){
        film.setIdFilm(UUID.fromString(UUID.randomUUID().toString()));
        return filmRepository.save(film);
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public Film updateFilm(Film film){
        return filmRepository.save(film);
    }

    public Film findFilmById(UUID id) throws Throwable {
        return filmRepository.findFilmById(id)
                .orElseThrow(() -> new ElementNotFoundException("Film was not found !"));
    }

    public void deleteFilm(UUID id){
        filmRepository.deleteFilmById(id);
    }
}
