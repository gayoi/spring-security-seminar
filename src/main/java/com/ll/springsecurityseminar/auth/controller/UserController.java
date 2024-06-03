package com.ll.springsecurityseminar.auth.controller;

import com.ll.springsecurityseminar.auth.service.UserService;
import com.ll.springsecurityseminar.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @GetMapping("/{id}")
    public ResponseEntity<?> read(HttpServletRequest request, @PathVariable Long id) {
        Long userId = jwtUtil.getUserId(jwtUtil.resolveToken(request).substring(7));
        if (!userId.equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.read(id));
    }


}
