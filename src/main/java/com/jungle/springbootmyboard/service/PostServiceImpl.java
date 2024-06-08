package com.jungle.springbootmyboard.service;

import com.jungle.springbootmyboard.entity.Posts;
import com.jungle.springbootmyboard.dto.PostRequestDto;
import com.jungle.springbootmyboard.dto.PostResponseDto;
import com.jungle.springbootmyboard.exception.CustomException;
import com.jungle.springbootmyboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

//    @Autowired
//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    @Override
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDto getPostById(Long id) {
        Posts post = postRepository.findById(id)
                .orElseThrow(() -> new CustomException("Post not found"));
        return new PostResponseDto(post);
    }

    @Override
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Posts post = new Posts();
        post.setTitle(requestDto.getTitle());
        post.setAuthor(requestDto.getAuthor());
        post.setPassword(requestDto.getPassword());
        post.setContent(requestDto.getContent());
        Posts savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost);
    }

    @Override
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Posts post = postRepository.findById(id)
                .orElseThrow(() -> new CustomException("Post not found"));
        if (!post.getPassword().equals(requestDto.getPassword())) {
            throw new CustomException("Incorrect password");
        }
        post.setTitle(requestDto.getTitle());
        post.setAuthor(requestDto.getAuthor());
        post.setContent(requestDto.getContent());
        Posts updatedPost = postRepository.save(post);
        return new PostResponseDto(updatedPost);
    }

    // 선택한 게시글 삭제하고 Client 로 성공했다는 표시 반환해야함.
    /* ex)
        {
            "msg": "게시글 삭제 성공",
            "statusCode": 200
        }
     */
//    @Override
//    public void deletePost(Long id, String password) {
//        Posts post = postRepository.findById(id)
//                .orElseThrow(() -> new CustomException("Post not found"));
//        if (!post.getPassword().equals(password)) {
//            throw new CustomException("Incorrect password");
//        }
//        postRepository.delete(post);
//    }

    @Override
    public Map<String, Object> deletePost(Long id, String password) {
        Posts post = postRepository.findById(id)
                .orElseThrow(() -> new CustomException("Post not found"));
        if (!post.getPassword().equals(password)) {
            throw new CustomException("Incorrect password");
        }
        postRepository.delete(post);

        Map<String, Object> response = new HashMap<>();
        response.put("msg", "게시글 삭제 성공");
        response.put("statusCode", 200);
        return response;
    }

    // 미리 추가해놓음.
    public List<PostResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream().map(PostResponseDto::new).collect(Collectors.toList());
    }
}
