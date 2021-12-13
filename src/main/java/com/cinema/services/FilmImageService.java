package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.FilmImage;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.IFilmImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class FilmImageService implements IGenericRepository<FilmImage, UUID> {

    private final IFilmImageRepository filmImageRepository;

    @Autowired
    public FilmImageService(IFilmImageRepository filmImageRepository){
        this.filmImageRepository = filmImageRepository;
    }

    @Override
    public List<FilmImage> GetAll() {
        return filmImageRepository.findAll();
    }

    @Override
    public FilmImage AddEntity(FilmImage filmImage) {
        return filmImageRepository.save(filmImage);
    }

    @Override
    public FilmImage UpdateEntity(FilmImage filmImage) {
        return filmImageRepository.save(filmImage);
    }

    @Override
    public FilmImage GetOneById(UUID id) {
        return filmImageRepository.findFilmImageById(id)
                .orElseThrow(() -> new ElementNotFoundException("FilmImage was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        filmImageRepository.deleteFilmImageById(id);
    }
}
