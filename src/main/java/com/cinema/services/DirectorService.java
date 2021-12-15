package com.cinema.services;


import com.cinema.models.Director;
import com.cinema.repositories.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DirectorService extends AbstractService<Director, UUID> {

    @Autowired
    private IDirectorRepository directorRepository;

    @Override
    protected JpaRepository<Director, UUID> getRepository() {
        return directorRepository;
    }

/*    @Override
    public List<Director> GetAll() {
        return directorRepository.findAll();
    }

    @Override
    public Director AddEntity(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director UpdateEntity(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director GetOneById(UUID id) {
        return (Director) directorRepository.findDirectorById(id)
                .orElseThrow(() -> new ElementNotFoundException("Director was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        directorRepository.deleteDirectorById(id);
    }*/
}
