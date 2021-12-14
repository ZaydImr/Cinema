package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Room;
import com.cinema.repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RoomService extends AbstractService<Room, UUID> {

    @Autowired
    private IRoomRepository roomRepository;

    @Override
    protected JpaRepository<Room, UUID> getRepository() {
        return roomRepository;
    }

    /*@Override
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
    }*/
}
