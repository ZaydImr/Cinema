package com.cinema.services;

import com.cinema.models.Actor;
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

   public long getCountOfFilms(){
        return filmRepository.count();
   }

    public List<Film> GetAllByKeyword(String keyword) {
        return filmRepository.getAllByKeyword(keyword);
    }
}
