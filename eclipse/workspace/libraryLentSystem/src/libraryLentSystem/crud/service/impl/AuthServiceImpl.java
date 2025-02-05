package libraryLentSystem.crud.service.impl;

import libraryLentSystem.crud.CrudApplication;
import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignInResDto;
import libraryLentSystem.crud.dto.auth.SignUpReqDto;
import libraryLentSystem.crud.entity.UserEntity;
import libraryLentSystem.crud.repository.UserRepositery;
import libraryLentSystem.crud.service.AuthService;

public class AuthServiceImpl implements AuthService {

	private final UserRepositery repositery;
	
	public AuthServiceImpl(UserRepositery repositery) {
		this.repositery = repositery;
	}
	
	@Override
	public void signIn(SignInReqDto dto) {

		boolean existsId = repositery.existById(dto.getId());
		boolean pwCheck = true;
		if(!existsId) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		SignInResDto resDto = repositery.signIn(dto);
		if(resDto == null) {
			System.out.println("잘못된 아이디입니다.");
			return;
		}
		pwCheck = resDto.getPw().equals(dto.getPw());
		if(!pwCheck) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.println("로그인에 성공하셨습니다.");
		CrudApplication.SESSION = resDto.getId();
	}
	
	@Override
	public void signUp(SignUpReqDto dto) {
		String id = dto.getId();
		boolean existsId = repositery.existById(id);
		if(existsId) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		
		UserEntity entity = new UserEntity(dto);
		repositery.signUp(entity);
		System.out.println("회원가입이 완료되었습니다.");
	}


	

}
