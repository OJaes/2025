package com.korit.crud.service.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.repository.implement.UserRepositoryImplement;
import com.korit.crud.service.AuthService;

//6
public class AuthServiceImplement implements AuthService {

	private final UserRepository userRepository;
	// 의존성을 줄이기 위해 final 부착
	// final이 붙으면 클래스 인스턴스이므로 초기화가 필요함
	
	public AuthServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void signUp(SignUpRequestDto requestDto) {
		// 아이디가 중복됐는지 확인
		String id = requestDto.getId();
		// - 중복된 아이디라면 '중복된 아이디입니다.' 출력 후 메서드 종료
//		if(userRepository.existsById(id)) {
//			System.out.println("중복된 아이디입니다.");
//		}
		boolean existedId = userRepository.existsById(id);
		if(existedId) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		
		// 해당 유저 정보를 저장소에 저장 후 '성공했습니다.' 출력
//		String password = requestDto.getPassword();
//		String nickname = requestDto.getNickname();
//		UserEntity userEntity = new UserEntity(id, password, nickname);
		
		UserEntity userEntity = new UserEntity(requestDto);
		userRepository.save(userEntity);
		System.out.println("성공했습니다.");

	}

	
	@Override
	public void signIn(SignInRequestDto requestDto) {
		
		String id = requestDto.getId();
		// id에 해당하는 정보가 있는지 확인(인스턴스 찾기)
		// 존재하지 않는다면 '로그인 실패했습니다' 출력 후 메서드 종료
		// 찾은 정보의 비밀번호와 입력한 비밀번호가 일치하는지 확인
		// 같으면 '로그인 성공했습니다' 출력 후 메서드 종료
		// 다르면 '로그인 실패했습니다' 출력
		UserEntity entity = userRepository.findById(id);
		if(entity == null) {
			System.out.println("로그인 실패했습니다");
			return;
		}
//		String password = requestDto.getPassword();
//		String existPassword = entity.getPassword();
		if(!entity.getPassword().equals(requestDto.getPassword())) {
			System.out.println("로그인 실패했습니다");
			return;
		}
		// 로그인 정보 저장
		CrudApplication.SESSION = id;
		System.out.println("로그인 성공했습니다");
		
		
	}

}
