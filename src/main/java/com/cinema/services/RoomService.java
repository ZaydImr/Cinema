package com.cinema.services;

import com.cinema.models.Nationality;
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

    public List<Room> GetAllByKeyword(String keyword) {
        return roomRepository.getRoomByName(keyword);
    }
}
