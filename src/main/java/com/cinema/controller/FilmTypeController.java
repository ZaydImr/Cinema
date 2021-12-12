package com.cinema.controller;

import com.cinema.services.FilmTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmtype")
public class FilmTypeController {
    private FilmTypeService filmTypeService;
    public FilmTypeController(FilmTypeService filmTypeService){
        this.filmTypeService = filmTypeService;
    }
}
