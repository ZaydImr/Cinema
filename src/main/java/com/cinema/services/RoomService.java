package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Room;
import com.cinema.models.User;
import com.cinema.repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {
    private final IRoomRepository roomRepository;

    @Autowired
    public RoomService(IRoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room room){
        room.setIdRoom(UUID.fromString(UUID.randomUUID().toString()));
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room updateRoom(Room room){
        return roomRepository.save(room);
    }

    public Room findRoomById(UUID id) throws Throwable {
        return roomRepository.findRoomById(id)
                .orElseThrow(() -> new ElementNotFoundException("Room was not found !"));
    }
    public void deleteRoom(UUID id){
        roomRepository.deleteRoomById(id);
    }
}
