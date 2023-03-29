package com.practice.demo.service;

import com.practice.demo.entity.Post;
import com.practice.demo.payload.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getPosts();

    PostDTO addPost(PostDTO postDTO);
}
