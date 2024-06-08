package com.jungle.springbootmyboard.controller;

import com.jungle.springbootmyboard.dto.UserRequestDto;
import com.jungle.springbootmyboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserRequestDto requestDto) {
        Map<String, Object> response = userService.registerUser(requestDto);
        return ResponseEntity.ok(response);
    }}

