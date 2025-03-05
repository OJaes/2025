package com.korit.spring_basic.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.spring_basic.entity.UserEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class GetUserResponseDto extends ResponseDto{
        

    private String code;
    private String message;
    private String userId;
    private String userName;
    private String userAddress;
    
    private GetUserResponseDto(UserEntity userEntity) {
        super("SU", "Success.");
        this.userId = userEntity.getUserId();
        this.userName = userEntity.getUserName();
        this.userAddress = userEntity.getUserAddress();
    }
    
    public static ResponseEntity<GetUserResponseDto> success(UserEntity userEntity) {
        GetUserResponseDto responseBody = new GetUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
