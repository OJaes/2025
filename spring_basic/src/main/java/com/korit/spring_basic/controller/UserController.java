package com.korit.spring_basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.spring_basic.dto.PostUserRequestDto;
import com.korit.spring_basic.dto.ResponseDto;
import com.korit.spring_basic.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ResponseDto> postUser(@RequestBody @Valid PostUserRequestDto requestBody) {
        
        // ResponseEntity<ResponseDto> response = userService.postUser(requestBody);
        // userService.postUser(requestBody);
        
        return userService.postUser(requestBody);
    }
    
}
