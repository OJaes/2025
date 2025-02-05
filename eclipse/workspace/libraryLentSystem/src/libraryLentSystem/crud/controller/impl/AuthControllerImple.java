package libraryLentSystem.crud.controller.impl;

import libraryLentSystem.crud.CrudApplication;
import libraryLentSystem.crud.controller.AuthController;
import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignUpReqDto;
import libraryLentSystem.crud.service.AuthService;

public class AuthControllerImple implements AuthController{

	private final AuthService authService;
	
	public AuthControllerImple(AuthService authService) {
		this.authService = authService;
	}
	
	@Override
	public void signIn(SignInReqDto dto) {
		authService.signIn(dto);
	}
	
	@Override
	public void signUp(SignUpReqDto dto) {
		if(dto == null) {
			System.out.println("오류 발생");
			return;
		}
		
		if(dto.validate()) {
			return;
		}
		
		authService.signUp(dto);
	}

	
	

}
