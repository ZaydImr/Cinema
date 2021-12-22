package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Director;
import com.cinema.models.Events;
import com.cinema.models.Nationality;
import com.cinema.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventsApiController {
    public final EventsService eventsService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<Events>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<Events> page = new Page<>();
        page.setList(eventsService.getList(pageNumber));
        page.setNext(eventsService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(eventsService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Events>> getAllEvents(){
        List<Events> events = eventsService.getAll();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable("id") UUID id){
        Events event = null;
        try{event = eventsService.getElementById(id);}
        catch (Throwable e){e.printStackTrace();}
        return new ResponseEntity<>(event,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Events> addEvent(@RequestBody Events event){
        Events newEvent = eventsService.addEntity(event);
        return new ResponseEntity<>(newEvent,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Events> updateEvent(@RequestBody Events event){
        Events newEvent = eventsService.updateEntity(event);
        return new ResponseEntity<>(newEvent,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") UUID id){
        eventsService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
