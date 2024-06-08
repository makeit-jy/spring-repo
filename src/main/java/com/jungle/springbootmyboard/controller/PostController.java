package com.jungle.springbootmyboard.controller;

import com.jungle.springbootmyboard.dto.PostRequestDto;
import com.jungle.springbootmyboard.dto.PostResponseDto;
import com.jungle.springbootmyboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
private final PostService postService;

//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

//    @GetMapping("/hi")
//    public String test() {
//        return "hi";
//    }

    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

//    @DeleteMapping("/{id}")
//    public void deletePost(@PathVariable Long id, @RequestBody String password) {
//        postService.deletePost(id, password);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePost(@PathVariable Long id, @RequestBody String password) {
        Map<String, Object> response = postService.deletePost(id, password);
//        System.out.println("ResponseEntity = "+ResponseEntity.ok(response));
        return ResponseEntity.ok(response);
    }

}