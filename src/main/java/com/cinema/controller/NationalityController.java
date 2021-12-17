package com.cinema.controller;

import com.cinema.models.Nationality;
import com.cinema.services.NationalityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nationality")
public class NationalityController {

    private final NationalityService nationalityService;
    private final String list = "admin/nationality/list";

    public NationalityController(NationalityService nationalityService){
        this.nationalityService = nationalityService;
    }

    @GetMapping
    public String index()
    {
        return list;
    }

}
