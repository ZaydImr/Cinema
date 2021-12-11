package com.cinema.services;

import com.cinema.repositories.IFilmRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private IFilmRepository filmRepository;
    public FilmService(IFilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }
}
