package com.cinema.apicontroller;

import com.cinema.models.Comment;
import com.cinema.models.Director;
import com.cinema.services.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/director")
@RequiredArgsConstructor
public class DirectorApiController {
    public final DirectorService directorService;

    @GetMapping
    public String index() {
        return "redirect:/directors/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Director> page = directorService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "directors/list";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Director>> getAllDirectors(){
        List<Director> directors = directorService.getAll();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable("id") UUID id){
        Director director = null;
        try{director = directorService.getElementById(id);}
        catch (Throwable e ){ e.printStackTrace();}
        return new ResponseEntity<>(director,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Director> addDirector(@RequestBody Director director){
        Director newDirector = directorService.updateEntity(director);
        return new ResponseEntity<>(newDirector,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Director> updateDirector(@RequestBody Director director){
        Director updatedDirector = directorService.updateEntity(director);
        return new ResponseEntity<>(updatedDirector,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable("id") UUID id){
        directorService.deleteEntity(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
