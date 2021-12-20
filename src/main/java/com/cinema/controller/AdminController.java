package com.cinema.controller;

import com.cinema.services.NationalityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final String index = "admin/dashboard";
    private final String nationality = "admin/nationality";
    private final String actor = "admin/actor";
    private final String director = "admin/director";
    private final String event = "admin/event";
    private final String filmType = "admin/film-type";
    private final String film = "admin/film";
    private final String news = "admin/news";
    private final String room = "admin/room";
    private final String session = "admin/session";
    private final String account = "admin/create-account";

    @GetMapping
    public String index()
    {
        return index;
    }

    @GetMapping("nationality")
    public String getNationality()
    {
        return nationality;
    }

    @GetMapping("actor")
    public String getActor(){ return actor; }

    @GetMapping("director")
    public String getDirector()
    {
        return director;
    }

    @GetMapping("event")
    public String getEvent()
    {
        return event;
    }

    @GetMapping("category")
    public String getFilmType()
    {
        return filmType;
    }

    @GetMapping("film")
    public String getFilm()
    {
        return film;
    }

    @GetMapping("news")
    public String getNews()
    {
        return news;
    }

    @GetMapping("room")
    public String getRoom()
    {
        return room;
    }

    @GetMapping("session")
    public String getSession()
    {
        return session;
    }

    @GetMapping("account")
    public String getAccount()
    {
        return account;
    }

}
