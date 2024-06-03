package com.ll.springsecurityseminar.auth.controller;

import com.ll.springsecurityseminar.auth.dto.SignInReqDto;
import com.ll.springsecurityseminar.auth.dto.SignUpReqDto;
import com.ll.springsecurityseminar.auth.service.AuthService;
import com.ll.springsecurityseminar.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpReqDto dto) {
        userService.create(dto.toEntity());
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInReqDto dto) {
        return ResponseEntity.ok(authService.signIn(dto));
    }
}
