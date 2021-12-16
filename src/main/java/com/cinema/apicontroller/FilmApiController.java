package com.cinema.apicontroller;

import com.cinema.models.Director;
import com.cinema.models.Film;
import com.cinema.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/film")
@RequiredArgsConstructor
public class FilmApiController {
    public final FilmService filmService;

    @GetMapping
    public String index() {
        return "redirect:/films/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Film> page = filmService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "films/list";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms(){
        List<Film> films = filmService.getAll();
        return new ResponseEntity<>(films, HttpStatus.OK);
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
