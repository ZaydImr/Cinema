package com.cinema.apicontroller;

import com.cinema.models.ActorFilm;
import com.cinema.services.ActorFilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/actorsfilm")
@RequiredArgsConstructor
public class ActorFilmApiController {
    public final ActorFilmService actorFilmService;

    @GetMapping
    public String index() {
        return "redirect:/actorsfilm/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<ActorFilm> page = actorFilmService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "actorsfilm/list";
    }

    @GetMapping("/all")
    public ResponseEntity<List<ActorFilm>> getAllActorsByFilm(){
        List<ActorFilm> actorsByFilm = actorFilmService.getAll();
        return new ResponseEntity<>(actorsByFilm, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ActorFilm> getActorFilmById(@PathVariable("id") UUID id) {
        ActorFilm actorFilm = null;
        try {
            actorFilm = actorFilmService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(actorFilm, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ActorFilm> addActorByFilm(@RequestBody ActorFilm actorFilm) {
        ActorFilm newActorFilm = actorFilmService.addEntity(actorFilm);
        return new ResponseEntity<>(newActorFilm, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ActorFilm> updateActorByFilm(@RequestBody ActorFilm actorFilm) {
        ActorFilm updatedActorFilm = actorFilmService.updateEntity(actorFilm);
        return new ResponseEntity<>(updatedActorFilm, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActorByFilm(@PathVariable("id") UUID id){
        actorFilmService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
