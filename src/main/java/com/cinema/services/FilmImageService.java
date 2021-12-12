package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.FilmImage;
import com.cinema.repositories.IFilmImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmImageService implements IGenericRepository<FilmImage, UUID> {
    private IFilmImageRepository filmImageRepository;
    public FilmImageService(IFilmImageRepository filmImageRepository){
        this.filmImageRepository = filmImageRepository;
    }

    @Override
    public List<FilmImage> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(FilmImage obj) {

    }

    @Override
    public void UpdateEntity(FilmImage obj) {

    }

    @Override
    public FilmImage GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
