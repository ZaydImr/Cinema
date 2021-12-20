package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final String index = "user/index";
    private final String login = "login";
    private final String register = "register";

    @GetMapping
    public String index()
    {
        return index;
    }

    @GetMapping("login")
    public String getLogin()
    {
        return login;
    }

    @GetMapping("register")
    public String getRegister()
    {
        return register;
    }
}
