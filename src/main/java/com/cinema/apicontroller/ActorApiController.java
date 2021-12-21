package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Actor;
import com.cinema.models.Director;
import com.cinema.models.Nationality;
import com.cinema.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/actor")
@CrossOrigin(origins = "")
@RequiredArgsConstructor
public class ActorApiController {
    public final ActorService actorService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<Actor>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<Actor> page = new Page<>();
        page.setList(actorService.getList(pageNumber));
        page.setNext(actorService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(actorService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Actor>> getAllActors(){
        List<Actor> actors = actorService.getAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/all/keyword/{keyword}")
    public ResponseEntity<List<Actor>> getAllByKeyword(@PathVariable("keyword") String keyword){
        List<Actor> rooms = actorService.GetAllByKeyword(keyword);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
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
