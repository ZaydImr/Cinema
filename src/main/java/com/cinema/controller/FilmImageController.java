package com.cinema.controller;

import com.cinema.services.FilmImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmimage")
public class FilmImageController {
    private final FilmImageService filmImageService;
    public FilmImageController(FilmImageService filmImageService){
        this.filmImageService = filmImageService;
    }
}
