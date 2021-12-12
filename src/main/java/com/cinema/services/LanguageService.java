package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Language;
import com.cinema.models.User;
import com.cinema.repositories.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LanguageService {
    private final ILanguageRepository languageRepository;

    @Autowired
    public LanguageService(ILanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    public Language addLanguage(Language language){
        language.setIdLanguage(UUID.fromString(UUID.randomUUID().toString()));
        return languageRepository.save(language);
    }

    public List<Language> getAllLanguages(){
        return languageRepository.findAll();
    }

    public Language updateLanguage(Language language){
        return languageRepository.save(language);
    }

    public Language findLanguageById(UUID id) throws Throwable {
        return languageRepository.findLanguageById(id)
                .orElseThrow(() -> new ElementNotFoundException("Language was not found !"));
    }

    public void deleteLanguage(UUID id){
        languageRepository.deleteLanguageById(id);
    }
}
