package com.korit.spring_basic.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequestDto {
    @NotBlank
    private String userId;
    @NotBlank
    private String userPassword;

    
}
