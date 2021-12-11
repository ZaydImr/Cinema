package com.cinema.services;

import com.cinema.repositories.IDirectorRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private IDirectorRepository directorRepository;
    public DirectorService(IDirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }
}
