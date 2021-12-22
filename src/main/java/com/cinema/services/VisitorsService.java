package com.cinema.services;

import com.cinema.models.News;
import com.cinema.models.Visitors;
import com.cinema.repositories.INewsRepository;
import com.cinema.repositories.IVisitorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VisitorsService extends AbstractService<Visitors, UUID> {

    @Autowired
    private IVisitorsRepository visitorsRepository;

    @Override
    protected JpaRepository<Visitors, UUID> getRepository() {
        return visitorsRepository;
    }

    public int GetTodaysVisitors(LocalDate date) {
        return visitorsRepository.getVisitorsCountBYDate(date);
    }

    public List<Integer> GetMonthVisitors(LocalDate date) {
        List<Integer> list = new ArrayList<>();
        for (int i = -29; i <=0; i++) {
            LocalDate newDate = date.plusDays(i);
            list.add(GetTodaysVisitors(newDate));
        }
        return list;
    }
}
