package libraryLentSystem.crud.service;

import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignUpReqDto;

public interface AuthService {
	
	void signIn(SignInReqDto dto);
	void signUp(SignUpReqDto dto);
	
}
