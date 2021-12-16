package com.cinema.apicontroller;

import com.cinema.models.Director;
import com.cinema.models.Session;
import com.cinema.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public String index() {
        return "redirect:/sessions/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Session> page = sessionService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "sessions/list";
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
