package com.cinema.apicontroller;

import com.cinema.models.Director;
import com.cinema.models.Nationality;
import com.cinema.services.NationalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nationality")
@RequiredArgsConstructor
public class NationalityApiController {
    public final NationalityService nationalityService;

    @GetMapping
    public String index() {
        return "redirect:/nationalities/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Nationality> page = nationalityService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "nationalities/list";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Nationality>> getAllNationalities(){
        List<Nationality> nationalities = nationalityService.getAll();
        return new ResponseEntity<>(nationalities, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Nationality> getNationalityById(@PathVariable("id") UUID id) {
        Nationality nationality = null;
        try {
            nationality = nationalityService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(nationality, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Nationality> addNationality(@RequestBody Nationality nationality) {
        Nationality newNationality = nationalityService.addEntity(nationality);
        return new ResponseEntity<>(newNationality, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Nationality> updateNationality(@RequestBody Nationality nationality) {
        Nationality updatedNationality = nationalityService.updateEntity(nationality);
        return new ResponseEntity<>(updatedNationality, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNationality(@PathVariable("id") UUID id){
        nationalityService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
