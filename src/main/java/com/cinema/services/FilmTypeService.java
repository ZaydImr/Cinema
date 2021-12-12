package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.FilmType;
import com.cinema.repositories.IFilmtypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmTypeService implements IGenericRepository<FilmType, UUID> {
    private IFilmtypeRepository filmtypeRepository;
    public FilmTypeService(IFilmtypeRepository filmtypeRepository){
        this.filmtypeRepository = filmtypeRepository;
    }

    @Override
    public List<FilmType> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(FilmType obj) {

    }

    @Override
    public void UpdateEntity(FilmType obj) {

    }

    @Override
    public FilmType GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
