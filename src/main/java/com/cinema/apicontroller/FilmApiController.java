package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Film;
import com.cinema.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/film")
@RequiredArgsConstructor
public class FilmApiController {
    public final FilmService filmService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<Page<Film>> list(@PathVariable Integer pageNumber) {
        Page<Film> page = new Page<>();
        page.setList(filmService.getList(pageNumber));
        page.setNext(filmService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(filmService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms(){
        List<Film> films = filmService.getAll();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllFilms(){
        Long count = filmService.getCountOfFilms();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id")UUID id){
        Film film = null;
        try{ film = filmService.getElementById(id);}
        catch (Throwable e){ e.printStackTrace();}
        return new ResponseEntity<>(film,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Film> addFilm(@RequestBody Film film){
        Film newFilm = filmService.addEntity(film);
        return new ResponseEntity<>(newFilm,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Film> updateFilm(@RequestBody Film film) {
        Film updatedFilm = filmService.updateEntity(film);
        return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable("id") UUID id){
        filmService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
