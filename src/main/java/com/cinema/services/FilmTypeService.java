package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.FilmType;
import com.cinema.models.User;
import com.cinema.repositories.IFilmtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmTypeService {
    private final IFilmtypeRepository filmtypeRepository;

    @Autowired
    public FilmTypeService(IFilmtypeRepository filmtypeRepository){
        this.filmtypeRepository = filmtypeRepository;
    }

    public FilmType addFilmType(FilmType filmType){
        filmType.setIdTypeFilm(UUID.fromString(UUID.randomUUID().toString()));
        return filmtypeRepository.save(filmType);
    }

    public List<FilmType> getAllFilmTypes(){
        return filmtypeRepository.findAll();
    }

    public FilmType updateFilmType(FilmType filmType){
        return filmtypeRepository.save(filmType);
    }

    public FilmType findFilmTypeById(UUID id) throws Throwable {
        return filmtypeRepository.findFilmTypeById(id)
                .orElseThrow(() -> new ElementNotFoundException("FilmType was not found !"));
    }

    public void deleteFilmType(UUID id){
        filmtypeRepository.deleteFilmTypeById(id);
    }
}
