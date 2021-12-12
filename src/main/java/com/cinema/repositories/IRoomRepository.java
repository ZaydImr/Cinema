package com.cinema.repositories;

import com.cinema.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRoomRepository extends JpaRepository<Room, UUID> {
    void deleteRoomById(UUID id);

    Optional<Room> findRoomById(UUID id);
}
