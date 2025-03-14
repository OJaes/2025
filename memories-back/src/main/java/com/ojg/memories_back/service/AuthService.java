package com.ojg.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ojg.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.ojg.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.ojg.memories_back.common.dto.response.ResponseDto;

public interface AuthService {
  ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
}