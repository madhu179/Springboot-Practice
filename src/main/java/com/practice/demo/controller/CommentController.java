package com.practice.demo.controller;

import com.practice.demo.payload.CommentDTO;
import com.practice.demo.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comments/{id}")
    public CommentDTO getCommentByID(@PathVariable long id){
        return commentService.getCommentById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/comment/{id}")
    public ResponseEntity addComment(@RequestBody CommentDTO commentDTO, @PathVariable long id){
        commentDTO = commentService.addComment(commentDTO, id);
        return new ResponseEntity(commentDTO, HttpStatus.OK);
    }
}
