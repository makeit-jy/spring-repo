package com.jungle.springbootmyboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String author;
    private String password;
    private String content;
}

