package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Director;
import com.cinema.models.Film;
import com.cinema.models.FilmImage;
import com.cinema.models.Nationality;
import com.cinema.services.FilmImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/filmimages")
@RequiredArgsConstructor
public class FilmImageApiController {
    public final FilmImageService filmImageService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<FilmImage>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<FilmImage> page = new Page<>();
        page.setList(filmImageService.getList(pageNumber));
        page.setNext(filmImageService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(filmImageService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FilmImage>> getAllFilmImage(){
        List<FilmImage> filmImages = filmImageService.getAll();
        return new ResponseEntity<>(filmImages, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FilmImage> getFilmImageById(@PathVariable("id") UUID id) {
        FilmImage filmImage = null;
        try {
            filmImage = filmImageService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(filmImage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FilmImage> addFilmImage(@RequestBody FilmImage filmImage) {
        FilmImage newFilmImage = filmImageService.addEntity(filmImage);
        return new ResponseEntity<>(newFilmImage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<FilmImage> updateFilmImage(@RequestBody FilmImage filmImage) {
        FilmImage updatedFilmImage = filmImageService.updateEntity(filmImage);
        return new ResponseEntity<>(updatedFilmImage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilmImage(@PathVariable("id") UUID id){
        filmImageService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
