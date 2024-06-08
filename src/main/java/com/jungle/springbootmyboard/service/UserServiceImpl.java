package com.jungle.springbootmyboard.service;

import com.jungle.springbootmyboard.dto.UserRequestDto;
import com.jungle.springbootmyboard.entity.User;
import com.jungle.springbootmyboard.repository.UserRepository;
import com.jungle.springbootmyboard.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public Map<String, Object> registerUser(UserRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        // username 유효성 검사
        if (!Pattern.matches("^[a-z0-9]{4,10}$", username)) {
            throw new CustomException("Invalid username format");
        }

        // password 유효성 검사
        if (!Pattern.matches("^[a-zA-Z0-9]{8,15}$", password)) {
            throw new CustomException("Invalid password format");
        }

        // username 중복 검사
        if (userRepository.findByUsername(username).isPresent()) {
            throw new CustomException("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("msg", "회원가입 성공");
        response.put("statusCode", 200);
        return response;
    }

}
