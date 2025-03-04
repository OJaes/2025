package com.korit.spring_basic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDto {
    
    private String code;
    private String message;
}
