package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Nationality;
import com.cinema.models.News;
import com.cinema.services.NationalityService;
import com.cinema.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nationality")
@RequiredArgsConstructor
public class NewsApiController {
    public final NewsService newsService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<Page<News>> list(@PathVariable Integer pageNumber) {
        Page<News> page = new Page<>();
        page.setList(newsService.getList(pageNumber));
        page.setNext(newsService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(newsService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<News>> getAllNationalities(){
        List<News> news = newsService.getAll();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/all/keyword/{keyword}")
    public ResponseEntity<List<News>> getAllByKeyword(@PathVariable("keyword") String keyword){
        List<News> news = newsService.GetAllByKeyword(keyword);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<News> getNationalityById(@PathVariable("id") UUID id) {
        News news = null;
        try {
            news = newsService.getElementById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<News> addNationality(@RequestBody News news) {
        News newNews = newsService.addEntity(news);
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<News> updateNationality(@RequestBody News news) {
        News updatedNews = newsService.updateEntity(news);
        return new ResponseEntity<>(updatedNews, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable("id") UUID id){
        newsService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
