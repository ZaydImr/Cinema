package com.cinema.controller;

import com.cinema.services.NationalityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nationality")
public class NationalityController {
    private NationalityService nationalityService;
    public NationalityController(NationalityService nationalityService){
        this.nationalityService = nationalityService;
    }
}
