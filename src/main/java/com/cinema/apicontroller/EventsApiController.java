package com.cinema.apicontroller;

import com.cinema.models.Events;
import com.cinema.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Events")
@RequiredArgsConstructor
public class EventsApiController {
    public final EventsService eventsService;

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
