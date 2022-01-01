package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Comment;
import com.cinema.models.Nationality;
import com.cinema.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentApiController {
    public final CommentService commentService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<Comment>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<Comment> page = new Page<>();
        page.setList(commentService.getList(pageNumber));
        page.setNext(commentService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(commentService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Comment>> getFilmImageById(@PathVariable("id") UUID id) {
        List<Comment> comments = null;
        try {
            comments = commentService.getCommentByFilmId(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment newComment = commentService.addEntity(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment updatedComment = commentService.updateEntity(comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") UUID id){
        commentService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
