package com.korit.spring_basic.service;

import org.springframework.http.ResponseEntity;

import com.korit.spring_basic.dto.SignInRequestDto;
import com.korit.spring_basic.dto.SignUpRequestDto;

public interface SecurityService {
    ResponseEntity<String> signUp(SignUpRequestDto dto);
    ResponseEntity<String> signIn(SignInRequestDto dto);
}
