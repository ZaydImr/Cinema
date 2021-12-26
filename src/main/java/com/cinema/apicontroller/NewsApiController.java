package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Nationality;
import com.cinema.models.News;
import com.cinema.services.EmailSenderService;
import com.cinema.services.NationalityService;
import com.cinema.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsApiController {

    public final EmailSenderService emailSenderService;
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
    public ResponseEntity<List<News>> getAllNews(){
        List<News> news = newsService.getAll();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/all/keyword/{keyword}")
    public ResponseEntity<List<News>> getAllByKeyword(@PathVariable("keyword") String keyword){
        List<News> news = newsService.GetAllByKeyword(keyword);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable("id") UUID id) {
        News news = null;
        try {
            news = newsService.getElementById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News newNews = newsService.addEntity(news);
        emailSenderService.sendSimpleEmail(news.getContent(),news.getSubject());
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }

    @PostMapping("/addAttached")
    public ResponseEntity<?> sendAttachmentEmail(@RequestBody News news) {
        //this.emailSenderService.sendEmailWithAttachment(news.getContent(),news.getSubject(),);
        News newNews = newsService.addEntity(news);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
