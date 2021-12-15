package com.cinema.apicontroller;

import com.cinema.models.Session;
import com.cinema.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionApiController {
    public final SessionService sessionService;

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
