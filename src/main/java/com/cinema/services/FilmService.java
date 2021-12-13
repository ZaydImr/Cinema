package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Film;
import com.cinema.repositories.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService implements IGenericRepository<Film, UUID> {
    private IFilmRepository filmRepository;

    @Autowired
    public FilmService(IFilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> GetAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film AddEntity(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film UpdateEntity(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film GetOneById(UUID id) {
        return filmRepository.findFilmById(id)
                .orElseThrow(() -> new ElementNotFoundException("Film was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        filmRepository.deleteFilmById(id);
    }
}
