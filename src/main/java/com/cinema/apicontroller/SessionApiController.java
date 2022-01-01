package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Director;
import com.cinema.models.Film;
import com.cinema.models.Nationality;
import com.cinema.models.Session;
import com.cinema.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionApiController {
    public final SessionService sessionService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<Session>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<Session> page = new Page<>();
        page.setList(sessionService.getList(pageNumber));
        page.setNext(sessionService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(sessionService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> sessions = sessionService.getAll();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable("id") UUID id) {
        Session session = null;
        try {
            session = sessionService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(session, HttpStatus.OK);
    }

    @GetMapping("/all/keyword/{keyword}")
    public ResponseEntity<List<Session>> getAllByKeyword(@PathVariable("keyword") String keyword){
        List<Session> sessions = sessionService.GetAllByKeyword(keyword);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Session> addSession(@RequestBody Session session) {
        Session newSession = sessionService.addEntity(session);
        return new ResponseEntity<>(newSession, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Session> updateSession(@RequestBody Session session) {
        Session updatedSession = sessionService.updateEntity(session);
        return new ResponseEntity<>(updatedSession, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable("id") UUID id){
        sessionService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
