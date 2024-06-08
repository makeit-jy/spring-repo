package com.jungle.springbootmyboard.dto;

import com.jungle.springbootmyboard.entity.Posts;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostResponseDto(Posts post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        System.out.println("@@@ PostResponseDto @@@");
    }
}
