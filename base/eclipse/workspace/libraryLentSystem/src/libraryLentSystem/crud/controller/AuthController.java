package libraryLentSystem.crud.controller;

import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignUpReqDto;

public interface AuthController {
	
	void signIn(SignInReqDto dto);
	void signUp(SignUpReqDto dto);
}
