package com.ll.springsecurityseminar.auth.service;

import com.ll.springsecurityseminar.auth.entitiy.User;
import com.ll.springsecurityseminar.auth.dto.SignInReqDto;
import com.ll.springsecurityseminar.auth.dto.SignInResDto;
import com.ll.springsecurityseminar.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public SignInResDto signIn(SignInReqDto dto) {
        User user = userService.read(dto.getUsername());
        if (user.getPassword().equals(dto.getPassword())) {
            return new SignInResDto(jwtUtil.generateToken(user.getUsername(), user.getId()));
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}
