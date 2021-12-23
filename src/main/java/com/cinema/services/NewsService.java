package com.cinema.services;

import com.cinema.models.Nationality;
import com.cinema.models.News;
import com.cinema.repositories.INationalityRepository;
import com.cinema.repositories.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NewsService extends AbstractService<News, UUID> {

    @Autowired
    private INewsRepository newsRepository;

    @Override
    protected JpaRepository<News, UUID> getRepository() {
        return newsRepository;
    }

    public List<News> GetAllByKeyword(String keyword) {
        return newsRepository.getNewsByKeyword(keyword);
    }

}
