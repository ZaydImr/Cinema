package com.cinema.services;

import com.cinema.repositories.IRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private IRoomRepository roomRepository;
    public RoomService(IRoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }
}
