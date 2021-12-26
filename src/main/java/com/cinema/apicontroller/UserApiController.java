package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Director;
import com.cinema.models.Nationality;
import com.cinema.models.Role;
import com.cinema.models.User;
import com.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")

public class UserApiController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserApiController(UserService userService){
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllFilms(){
        Long count = userService.getCountOfUsers();
        return new ResponseEntity<>(count,HttpStatus.OK);
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

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        String encoderPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
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
