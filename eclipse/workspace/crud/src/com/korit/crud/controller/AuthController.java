package com.korit.crud.controller;

import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;

//2

// Controller : 클라이언트와 서버간의 접점에 해당하는 모듈(레이어)
// 요청(입력)에 대한 검증, 응담(출력)에 대한 분기 처리

// 인증, 인가 작업(회원가입, 로그인)
// DIP에 의해 의존성을 추상화에 의존하기 위해 인터페이스로 먼저 정의를 함
public interface AuthController {
	
//	 인터페이스에 추상 메서드 하나만 있으면 함수형 인터페이스
	// 회원가입
	void signUp(SignUpRequestDto requestDto);
	
	// 로그인
	void signIn(SignInRequestDto requestDto);
	
}
