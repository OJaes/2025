package com.korit.spring_basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.spring_basic.dto.PostUserRequestDto;
import com.korit.spring_basic.dto.ResponseDto;
import com.korit.spring_basic.entity.UserEntity;
import com.korit.spring_basic.repository.UserRepository;
import com.korit.spring_basic.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    

    @Override
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {

        // unique값이 맞는지 확인(userId,telNumber)
        // UserEntity entity = userRepository.findByUserId(dto.getUserId());
        
        // if(userRepository.findByUserId(dto.getUserId()) != null){
        boolean existsByUserId = userRepository.existsByUserId(dto.getUserId());
        if(existsByUserId){
            ResponseDto responseBody = new ResponseDto("DI","Duplicated Id.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }
        // if(userRepository.findByUserTelNumber(dto.getUserTelNumber()) != null){
        boolean existsByUserTelNumber = userRepository.existsByUserTelNumber(dto.getUserTelNumber());
        if(existsByUserTelNumber){
            ResponseDto responseBody = new ResponseDto("DT","Duplicated TelNumber.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }

        // builder 패턴 : 객체 생성 과정에 멤버 변수 별로 객체를 구성한 후 객체를 생성할 수 있도록 도움을 주는 생성 패턴
        // 가독성 향상, 객체 불변성 보장(1회용 setter이라 생각하면 됨)
        // UserEntity userEntity = new UserEntity().builder()
        //                                         .userId(dto.getUserId())
        //                                         .userPassword(dto.getUserPassword())
        //                                         .userName(dto.getUserName())
        //                                         .userTelNumber(dto.getUserTelNumber())
        //                                         .userAddress(dto.getUserAddress())
        //                                         .build();

        // UserEntity userEntity = new UserEntity(dto.getUserId(),dto.getUserPassword(),dto.getUserName(),dto.getUserAddress(),dto.getUserTelNumber());
        UserEntity userEntity = new UserEntity(dto);
        userRepository.save(userEntity);

        // ResponseDto response = new ResponseDto("SU","Success.");
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("SU","Success."));
    }
    
}
