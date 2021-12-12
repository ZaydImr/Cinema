package com.cinema.controller;

import com.cinema.services.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {
    private FilmService filmService;
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }
}
