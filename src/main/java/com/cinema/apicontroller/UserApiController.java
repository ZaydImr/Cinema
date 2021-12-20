package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Director;
import com.cinema.models.Nationality;
import com.cinema.models.User;
import com.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    public final UserService userService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<User>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<User> page = new Page<>();
        page.setList(userService.getList(pageNumber));
        page.setNext(userService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(userService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> Users = userService.getAll();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") UUID id) {
        User user = null;
        try {
            user = userService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addEntity(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateEntity(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable("id") UUID id){
        userService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
