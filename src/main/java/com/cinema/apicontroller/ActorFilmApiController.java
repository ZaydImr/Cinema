package com.cinema.apicontroller;

import com.cinema.models.ActorFilm;
import com.cinema.services.ActorFilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/actorsfilm")
@RequiredArgsConstructor
public class ActorFilmApiController {
    public final ActorFilmService actorFilmService;

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
