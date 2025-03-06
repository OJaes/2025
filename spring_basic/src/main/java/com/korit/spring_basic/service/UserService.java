package com.korit.spring_basic.service;

import org.springframework.http.ResponseEntity;

import com.korit.spring_basic.dto.GetUserListResponseDto;
import com.korit.spring_basic.dto.GetUserResponseDto;
import com.korit.spring_basic.dto.PatchUserRequestDto;
import com.korit.spring_basic.dto.PostUserRequestDto;
import com.korit.spring_basic.dto.ResponseDto;

public interface UserService {
    
    ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);
    public ResponseEntity<? super GetUserResponseDto> getUser(String userId);
    ResponseEntity<ResponseDto> deleteUser(String userId);
    ResponseEntity<ResponseDto> patchUser(String userId, PatchUserRequestDto dto);
    public ResponseEntity<? super GetUserListResponseDto> getUserList();
}
