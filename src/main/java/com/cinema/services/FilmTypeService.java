package com.cinema.services;

import com.cinema.models.FilmType;
import com.cinema.models.Room;
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

    public List<FilmType> GetAllByKeyword(String keyword) {
        return filmtypeRepository.getByName(keyword);
    }
}
