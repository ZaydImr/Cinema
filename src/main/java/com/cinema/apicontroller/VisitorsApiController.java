package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Nationality;
import com.cinema.models.Visitors;
import com.cinema.services.NationalityService;
import com.cinema.services.VisitorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/visitors")
@RequiredArgsConstructor
public class VisitorsApiController {
    public final VisitorsService visitorsService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<Page<Visitors>> list(@PathVariable Integer pageNumber) {
        Page<Visitors> page = new Page<>();
        page.setList(visitorsService.getList(pageNumber));
        page.setNext(visitorsService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(visitorsService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visitors>> getAllVisitors(){
        List<Visitors> nationalities = visitorsService.getAll();
        return new ResponseEntity<>(nationalities, HttpStatus.OK);
    }

    @GetMapping("/today")
    public ResponseEntity<Integer> getAllVisitorsByDay(){
        Integer visitors = visitorsService.GetTodaysVisitors(LocalDate.now());
        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<List<Integer>> getAllVisitorsByMonth(){
        List<Integer> visitors = new ArrayList<>();
        for(int i = 29 ;i>=0;i--)
            visitors.add(visitorsService.GetTodaysVisitors(LocalDate.now().plusDays(-i)));
        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Visitors> getVisitorById(@PathVariable("id") UUID id) {
        Visitors visitors = null;
        try {
            visitors = visitorsService.getElementById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Visitors> addVisitor(@RequestBody Visitors visitors) {
        visitors.setDateVisit(LocalDate.now());
        Visitors newVisitors = visitorsService.addEntity(visitors);
        return new ResponseEntity<>(newVisitors, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Visitors> updateVisitor(@RequestBody Visitors visitors) {
        Visitors updatedVisitors = visitorsService.updateEntity(visitors);
        return new ResponseEntity<>(updatedVisitors, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVisitor(@PathVariable("id") UUID id){
        visitorsService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
