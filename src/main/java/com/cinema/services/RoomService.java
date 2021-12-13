package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Room;
import com.cinema.repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RoomService implements IGenericRepository<Room, UUID> {
    private IRoomRepository roomRepository;

    @Autowired
    public RoomService(IRoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> GetAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room AddEntity(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room UpdateEntity(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room GetOneById(UUID id) {
        return roomRepository.findRoomById(id)
                .orElseThrow(() -> new ElementNotFoundException("Room was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        roomRepository.deleteRoomById(id);
    }
}
