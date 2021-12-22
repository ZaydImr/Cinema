package com.cinema.repositories;

import com.cinema.models.Nationality;
import com.cinema.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface INewsRepository extends JpaRepository<News, UUID> {

    @Query("SELECT n FROM News n WHERE n.subject LIKE %?1%")
    List<News> getNewsByKeyword(String keyword);
}
