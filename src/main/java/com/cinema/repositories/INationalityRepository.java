package com.cinema.repositories;

import com.cinema.models.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface INationalityRepository extends JpaRepository<Nationality, UUID> {

    @Query("SELECT n FROM Nationality n WHERE n.nationality LIKE %?1%")
    List<Nationality> getNationalityByNationality(String nationality);
}
