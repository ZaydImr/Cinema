package com.cinema.controller;

import com.cinema.services.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }
}