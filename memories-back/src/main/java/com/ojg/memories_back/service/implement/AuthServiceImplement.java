package com.ojg.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ojg.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.ojg.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.ojg.memories_back.common.dto.response.ResponseDto;
import com.ojg.memories_back.common.entity.UserEntity;
import com.ojg.memories_back.repository.UserRepository;
import com.ojg.memories_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {
    
    boolean existsId;

    try {
        String userId = dto.getUserId();
        existsId = userRepository.existsByUserId(userId);
        if(existsId){
            return ResponseDto.existUser();
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
  }


@Override
public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {

    try {
        
        String userId = dto.getUserId();
        boolean existsUser = userRepository.existsByUserId(userId);
        if(existsUser) return ResponseDto.existUser();
        
        String userPassword = dto.getUserPassword();
        String encodedPassword = passwordEncoder.encode(userPassword);

        UserEntity userEntity = new UserEntity(dto);
        userRepository.save(userEntity);

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);
}
  
}