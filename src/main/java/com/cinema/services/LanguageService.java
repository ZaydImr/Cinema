package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Language;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LanguageService implements IGenericRepository<Language, UUID> {
    private ILanguageRepository languageRepository;

    @Autowired
    public LanguageService(ILanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> GetAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language AddEntity(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language UpdateEntity(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language GetOneById(UUID id) {
        return languageRepository.findLanguageById(id)
                .orElseThrow(() -> new ElementNotFoundException("Language was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        languageRepository.deleteLanguageById(id);
    }
}
