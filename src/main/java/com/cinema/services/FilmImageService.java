package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.FilmImage;
import com.cinema.models.User;
import com.cinema.repositories.IFilmImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmImageService {
    private final IFilmImageRepository filmImageRepository;

    @Autowired
    public FilmImageService(IFilmImageRepository filmImageRepository){
        this.filmImageRepository = filmImageRepository;
    }

    public FilmImage addFilmImage(FilmImage filmImage){
        filmImage.setIdImageFilm(UUID.fromString(UUID.randomUUID().toString()));
        return filmImageRepository.save(filmImage);
    }

    public List<FilmImage> getAllFilmImages(){
        return filmImageRepository.findAll();
    }

    public FilmImage updateFilmImage(FilmImage filmImage){
        return filmImageRepository.save(filmImage);
    }

    public FilmImage findFilmImageById(UUID id) throws Throwable {
        return filmImageRepository.findFilmImageById(id)
                .orElseThrow(() -> new ElementNotFoundException("FilmImage was not found !"));
    }

    public void deleteFilmImage(UUID id){
        filmImageRepository.deleteFilmImageById(id);
    }
}
