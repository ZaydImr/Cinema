package com.cinema.services;


import com.cinema.dao.IGenericRepository;
import com.cinema.models.Director;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class DirectorService implements IGenericRepository<Director, UUID> {
    private final IDirectorRepository directorRepository;

    @Autowired
    public DirectorService(IDirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    @Override
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
    }
}
