package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final String index = "user/index";

    @GetMapping
    public String index()
    {
        return index;
    }
}
