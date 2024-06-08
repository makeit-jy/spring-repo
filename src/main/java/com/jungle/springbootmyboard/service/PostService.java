package com.jungle.springbootmyboard.service;

import com.jungle.springbootmyboard.dto.PostRequestDto;
import com.jungle.springbootmyboard.dto.PostResponseDto;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<PostResponseDto> getAllPosts();
    PostResponseDto getPostById(Long id);
    PostResponseDto createPost(PostRequestDto requestDto);
    PostResponseDto updatePost(Long id, PostRequestDto requestDto);
//    void deletePost(Long id, String password);
    Map<String, Object> deletePost(Long id, String password);
}
