package com.cinema.services;


import com.cinema.models.Director;
import com.cinema.models.FilmType;
import com.cinema.repositories.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DirectorService extends AbstractService<Director, UUID> {

    @Autowired
    private IDirectorRepository directorRepository;

    @Override
    protected JpaRepository<Director, UUID> getRepository() {
        return directorRepository;
    }

    public List<Director> GetAllByKeyword(String keyword) {
        return directorRepository.getAllByKeyword(keyword);
    }

}
