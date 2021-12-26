package com.cinema.apicontroller;

import com.cinema.models.Role;
import com.cinema.models.Room;
import com.cinema.models.User;
import com.cinema.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleApiController {

    public final RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<List<Role>> AddRoles(){
        roleService.addEntity(new Role("ROLE_ADMIN",new HashSet<>()));
        roleService.addEntity(new Role("ROLE_USER",new HashSet<>()));
        List<Role> roles = roleService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/find/{role}")
    public ResponseEntity<Role> getRoleByName(@PathVariable("role") String role) {
        Role r = null;
        try {
            r = roleService.getRoleByName(role);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
