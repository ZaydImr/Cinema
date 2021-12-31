package com.cinema.services;

import com.cinema.models.FilmImage;
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

    public List<String> getImageUrlByFilmId(UUID id) {
        return filmImageRepository.getImageUrlByFilmId(id);
    }
}
