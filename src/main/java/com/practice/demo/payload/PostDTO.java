package com.practice.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDTO> comments;
    private Set<String> tags;
}
