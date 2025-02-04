package com.ll.springsecurityseminar.auth.service;

import com.ll.springsecurityseminar.auth.entitiy.User;
import com.ll.springsecurityseminar.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public User read(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User read(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}