package com.cinema.repositories;

import com.cinema.models.Nationality;
import com.cinema.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRoomRepository extends JpaRepository<Room, UUID> {
    @Query("SELECT n FROM Room n WHERE n.nameRoom LIKE %?1%")
    List<Room> getRoomByName(String room);
}
