package com.korit.spring_basic.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDto {
    
    private String code;
    private String message;

    public static ResponseEntity<ResponseDto> success(HttpStatus status){
        return ResponseEntity.status(status).body(new ResponseDto("SU","Success."));
    }
    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto response = new ResponseDto("DBE","Database Error.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    public static ResponseEntity<ResponseDto> duplicatedId(){
        ResponseDto response = new ResponseDto("DI","Duplicated Id.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    public static ResponseEntity<ResponseDto> duplicatedTelNumber(){
        ResponseDto response = new ResponseDto("DT","Duplicated TelNumber.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto responseBody = new ResponseDto("NU", "No Exist User.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
      }
}
