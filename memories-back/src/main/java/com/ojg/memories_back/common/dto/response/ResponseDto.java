package com.ojg.memories_back.common.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public class ResponseDto {
  private String code;
  private String message;

  protected ResponseDto() {
    this.code = ResponseCode.SUCCESS;
    this.message = ResponseMessage.SUCCESS;
  }

  public static ResponseEntity<ResponseDto> success(HttpStatus status) {
    ResponseDto body = new ResponseDto();
    return ResponseEntity.status(status).body(body);
  }

  public static ResponseEntity<ResponseDto> validationFail() {
    ResponseDto body = new ResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }

  public static ResponseEntity<ResponseDto> existUser() {
    ResponseDto body = new ResponseDto(ResponseCode.EXIST_USER, ResponseMessage.EXIST_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }

  public static ResponseEntity<ResponseDto> databaseError() {
    ResponseDto body = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
  }
  
}