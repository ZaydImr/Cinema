package com.cinema.apicontroller;

import com.cinema.models.Room;
import com.cinema.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomApiController {
    public final RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = roomService.getAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") UUID id) {
        Room room = null;
        try {
            room = roomService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room newRoom = roomService.addEntity(room);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        Room updatedRoom = roomService.updateEntity(room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") UUID id){
        roomService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
