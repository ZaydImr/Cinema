package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.FilmType;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.IFilmtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class FilmTypeService extends AbstractService<FilmType, UUID> {

    @Autowired
    private IFilmtypeRepository filmtypeRepository;

    @Override
    protected JpaRepository<FilmType, UUID> getRepository() {
        return filmtypeRepository;
    }

    /*@Override
    public List<FilmType> GetAll() {
        return filmtypeRepository.findAll();
    }

    @Override
    public FilmType AddEntity(FilmType filmType) {
        return filmtypeRepository.save(filmType);
    }

    @Override
    public FilmType UpdateEntity(FilmType filmType) {
        return filmtypeRepository.save(filmType);
    }

    @Override
    public FilmType GetOneById(UUID id) {
        return filmtypeRepository.findFilmTypeById(id)
                .orElseThrow(() -> new ElementNotFoundException("FilmType was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        filmtypeRepository.deleteFilmTypeById(id);
    }*/
}
