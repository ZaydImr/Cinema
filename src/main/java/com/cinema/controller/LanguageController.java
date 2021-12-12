package com.cinema.controller;

import com.cinema.services.LanguageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/language")
public class LanguageController {
    private LanguageService languageService;
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }
}
