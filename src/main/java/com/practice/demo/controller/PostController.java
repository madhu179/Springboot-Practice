package com.practice.demo.controller;

import com.practice.demo.payload.PostDTO;
import com.practice.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    private PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostDTO> getPosts(){
        return postService.getPosts();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public ResponseEntity addPost(@RequestBody PostDTO postDTO){
        PostDTO postDTO1 = postService.addPost(postDTO);
        return new ResponseEntity(postDTO1, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/postGreeting")
//    public String postGreeting() {
//        return "Thank you";
//    }
}
