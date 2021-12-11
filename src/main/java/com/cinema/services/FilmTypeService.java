package com.cinema.services;

import com.cinema.repositories.IFilmtypeRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmTypeService {
    private IFilmtypeRepository filmtypeRepository;
    public FilmTypeService(IFilmtypeRepository filmtypeRepository){
        this.filmtypeRepository = filmtypeRepository;
    }
}
