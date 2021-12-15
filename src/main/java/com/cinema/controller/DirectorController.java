package com.cinema.controller;

import com.cinema.services.DirectorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/director")
public class DirectorController {
    private final DirectorService directorService;
    public DirectorController(DirectorService directorService){
        this.directorService = directorService;
    }
}
