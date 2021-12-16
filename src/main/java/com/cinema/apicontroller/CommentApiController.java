package com.cinema.apicontroller;

import com.cinema.models.Comment;
import com.cinema.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public String index() {
        return "redirect:/comments/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Comment> page = commentService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "comments/list";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") UUID id){
        Comment comment = null;
        try{ comment = commentService.getElementById(id);}
        catch(Throwable e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(comment,HttpStatus.OK);
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
