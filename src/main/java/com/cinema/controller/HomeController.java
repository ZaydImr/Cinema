package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final String index = "user/index";
    private final String login = "login";
    private final String register = "register";
    private final String actor = "user/actors";
    private final String director = "user/directors";
    private final String session = "user/session";
    private final String film = "user/film";
    private final String news = "user/news";

    @GetMapping("")
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

    @GetMapping("film/{id}")
    public String getFilm()
    {
        return film;
    }

    @GetMapping("actors")
    public String getActors()
    {
        return actor;
    }

    @GetMapping("directors")
    public String getDirectors()
    {
        return director;
    }

    @GetMapping("session")
    public String getSession()
    {
        return session;
    }

    @GetMapping("news")
    public String getNews()
    {
        return news;
    }
}
