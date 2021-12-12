package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Language;
import com.cinema.repositories.ILanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LanguageService implements IGenericRepository<Language, UUID> {
    private ILanguageRepository languageRepository;
    public LanguageService(ILanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Language obj) {

    }

    @Override
    public void UpdateEntity(Language obj) {

    }

    @Override
    public Language GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
