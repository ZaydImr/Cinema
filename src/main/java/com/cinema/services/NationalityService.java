package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Nationality;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.INationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class NationalityService extends AbstractService<Nationality, UUID> {

    @Autowired
    private INationalityRepository nationalityRepository;

    @Override
    protected JpaRepository<Nationality, UUID> getRepository() {
        return nationalityRepository;
    }

    /*@Override
    public List<Nationality> GetAll() {
        return nationalityRepository.findAll();
    }

    @Override
    public Nationality AddEntity(Nationality language) {
        return nationalityRepository.save(language);
    }

    @Override
    public Nationality UpdateEntity(Nationality language) {
        return nationalityRepository.save(language);
    }

    @Override
    public Nationality GetOneById(UUID id) {
        return nationalityRepository.findLanguageById(id)
                .orElseThrow(() -> new ElementNotFoundException("Language was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        nationalityRepository.deleteLanguageById(id);
    }*/
}
