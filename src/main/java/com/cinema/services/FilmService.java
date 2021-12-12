package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Film;
import com.cinema.repositories.IFilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService implements IGenericRepository<Film, UUID> {
    private IFilmRepository filmRepository;
    public FilmService(IFilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Film obj) {

    }

    @Override
    public void UpdateEntity(Film obj) {

    }

    @Override
    public Film GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
