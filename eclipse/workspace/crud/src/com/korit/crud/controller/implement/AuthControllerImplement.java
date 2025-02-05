package com.korit.crud.controller.implement;

import com.korit.crud.controller.AuthController;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.service.AuthService;

//4

public class AuthControllerImplement implements AuthController {

	private final AuthService authService;
	
	public AuthControllerImplement(AuthService authService) {
		
		this.authService = authService;	
		
	}
	
	@Override
	public void signUp(SignUpRequestDto requestDto) {
		
		if(requestDto == null) {
			System.out.println("오류 발생");
			return;
		}
		
		if(!requestDto.validate()) return;
		authService.signUp(requestDto);

	}

	@Override
	public void signIn(SignInRequestDto requestDto) {
		if(requestDto == null) {
			System.out.println("오류 발생");
			return;
		}
		
		if(requestDto.validate()) {
			authService.signIn(requestDto);
		}
		
	}

}
