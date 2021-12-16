package com.cinema.apicontroller;

import com.cinema.models.Director;
import com.cinema.models.FilmImage;
import com.cinema.services.FilmImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public String index() {
        return "redirect:/filmimages/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<FilmImage> page = filmImageService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "filmimages/list";
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
