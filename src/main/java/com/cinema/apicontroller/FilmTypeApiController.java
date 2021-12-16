package com.cinema.apicontroller;

import com.cinema.models.Director;
import com.cinema.models.FilmType;
import com.cinema.services.FilmTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/filmtypes")
@RequiredArgsConstructor
public class FilmTypeApiController {
    public final FilmTypeService filmTypeService;

    @GetMapping
    public String index() {
        return "redirect:/filmtypes/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<FilmType> page = filmTypeService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "filmtypes/list";
    }

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
