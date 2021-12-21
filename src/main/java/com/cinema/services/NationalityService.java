package com.cinema.services;

import com.cinema.models.Nationality;
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

    public List<Nationality> GetAllByKeyword(String keyword) {
        return nationalityRepository.getNationalityByNationality(keyword);
    }

}
