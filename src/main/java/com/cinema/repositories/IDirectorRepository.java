package com.cinema.repositories;

import com.cinema.models.Director;
import com.cinema.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDirectorRepository extends JpaRepository<Director, UUID> {
    @Query("SELECT d FROM Director d WHERE d.fullnameDirector LIKE %?1%")
    List<Director> getAllByKeyword(String fullname);
}
