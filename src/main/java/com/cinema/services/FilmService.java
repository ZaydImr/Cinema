package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Film;
import com.cinema.repositories.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService extends AbstractService<Film, UUID> {

    @Autowired
    private IFilmRepository filmRepository;

    @Override
    protected JpaRepository<Film, UUID> getRepository() {
        return filmRepository;
    }

    /*@Override
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
    }*/
}
