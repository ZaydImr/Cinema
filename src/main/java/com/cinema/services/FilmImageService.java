package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.FilmImage;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.IFilmImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class FilmImageService extends AbstractService<FilmImage, UUID> {

    @Autowired
    private IFilmImageRepository filmImageRepository;

    @Override
    protected JpaRepository<FilmImage, UUID> getRepository() {
        return filmImageRepository;
    }

    /*@Override
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
    }*/
}
