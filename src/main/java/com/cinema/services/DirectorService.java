package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Director;
import com.cinema.models.Events;
import com.cinema.repositories.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DirectorService {
    private final IDirectorRepository directorRepository;

    @Autowired
    public DirectorService(IDirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    public Director addDirector(Director director){
        director.setIdDirector(UUID.fromString(UUID.randomUUID().toString()));
        return directorRepository.save(director);
    }

    public Director getAllDirectors(){
        return (Director) directorRepository.findAll();
    }

    public Director updateDirector(Director director){
        return directorRepository.save(director);
    }

    public Director findDirectorById(UUID id) throws Throwable {
        return (Director) directorRepository.findDirectorById(id)
                .orElseThrow(() -> new ElementNotFoundException("Director was not found !"));
    }

    public void deleteDirector(UUID id){
        directorRepository.deleteDirectorById(id);
    }
}
