package com.cinema.apicontroller;

import com.cinema.models.FilmType;
import com.cinema.services.FilmTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/filmtypes")
@RequiredArgsConstructor
public class FilmTypeApiController {
    public final FilmTypeService filmTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<FilmType>> getAllFilmTypes(){
        List<FilmType> filmTypes = filmTypeService.getAll();
        return new ResponseEntity<>(filmTypes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FilmType> getFilmTypeById(@PathVariable("id") UUID id) {
        FilmType filmType = null;
        try {
            filmType = filmTypeService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(filmType, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FilmType> addFilmType(@RequestBody FilmType filmType) {
        FilmType newFilmType = filmTypeService.addEntity(filmType);
        return new ResponseEntity<>(newFilmType, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<FilmType> updateFilmType(@RequestBody FilmType filmType) {
        FilmType updateFilmType = filmTypeService.updateEntity(filmType);
        return new ResponseEntity<>(updateFilmType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilmType(@PathVariable("id") UUID id){
        filmTypeService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
