package com.jungle.springbootmyboard.service;

import com.jungle.springbootmyboard.dto.UserRequestDto;
import java.util.Map;

public interface UserService {
    Map<String, Object> registerUser(UserRequestDto requestDto);
}

