package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.repositories.IRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService implements IGenericRepository<RoomService, UUID> {
    private IRoomRepository roomRepository;
    public RoomService(IRoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomService> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(RoomService obj) {

    }

    @Override
    public void UpdateEntity(RoomService obj) {

    }

    @Override
    public RoomService GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
