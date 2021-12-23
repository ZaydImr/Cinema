package com.cinema.repositories;

import com.cinema.models.News;
import com.cinema.models.Visitors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IVisitorsRepository extends JpaRepository<Visitors, UUID> {

    @Query("SELECT count(v) FROM Visitors v WHERE v.dateVisit = ?1")
    int getVisitorsCountByDate(LocalDate date);

    @Query("SELECT count(v.dateVisit) from Visitors v GROUP BY v.dateVisit")
    List<Integer> getVisitorsCountByMonth(Pageable pageable);
}
