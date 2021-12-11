package com.cinema.services;

import com.cinema.repositories.IFilmImageRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmImageService {
    private IFilmImageRepository filmImageRepository;
    public FilmImageService(IFilmImageRepository filmImageRepository){
        this.filmImageRepository = filmImageRepository;
    }
}
