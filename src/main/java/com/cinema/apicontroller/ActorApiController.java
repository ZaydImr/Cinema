package com.cinema.apicontroller;

import com.cinema.models.Actor;
import com.cinema.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/actor")
@RequiredArgsConstructor
public class ActorApiController {
    public final ActorService actorService;

    @GetMapping
    public String index() {
        return "redirect:/actors/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Actor> page = actorService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "actors/list";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Actor>> getAllActors(){
        List<Actor> actors = actorService.getAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") UUID id) {
        Actor actor = null;
        try {
            actor = actorService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {
        Actor newActor = actorService.addEntity(actor);
        return new ResponseEntity<>(newActor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Actor> updateActor(@RequestBody Actor actor) {
        Actor updatedActor = actorService.updateEntity(actor);
        return new ResponseEntity<>(updatedActor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable("id") UUID id){
        actorService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
