package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Director;
import com.cinema.repositories.IDirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DirectorService implements IGenericRepository<Director, UUID> {
    private IDirectorRepository directorRepository;
    public DirectorService(IDirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }


    @Override
    public List<Director> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Director obj) {

    }

    @Override
    public void UpdateEntity(Director obj) {

    }

    @Override
    public Director GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
