package com.cinema.controller;

import com.cinema.models.Film;
import com.cinema.services.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    private final FilmService filmService;
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

}
