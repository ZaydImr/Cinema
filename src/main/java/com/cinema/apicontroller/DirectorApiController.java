package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Comment;
import com.cinema.models.Director;
import com.cinema.models.FilmType;
import com.cinema.models.Nationality;
import com.cinema.services.DirectorService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<Director>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<Director> page = new Page<>();
        page.setList(directorService.getList(pageNumber));
        page.setNext(directorService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(directorService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Director>> getAllDirectors(){
        List<Director> directors = directorService.getAll();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @GetMapping("/all/keyword/{keyword}")
    public ResponseEntity<List<Director>> getAllByKeyword(@PathVariable("keyword") String keyword){
        List<Director> rooms = directorService.GetAllByKeyword(keyword);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
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
