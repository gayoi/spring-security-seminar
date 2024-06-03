package com.ll.springsecurityseminar.auth.dto;

import com.ll.springsecurityseminar.auth.entitiy.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SignUpReqDto {
    private String username;
    private String name;
    private String password;
    private String phone;

    public User toEntity() {
        return User.builder()
                .username(username)
                .name(name)
                .password(password)
                .phone(phone)
                .build();
    }
}