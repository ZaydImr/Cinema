package com.cinema.services;

import com.cinema.repositories.ILanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    private ILanguageRepository languageRepository;
    public LanguageService(ILanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
}
