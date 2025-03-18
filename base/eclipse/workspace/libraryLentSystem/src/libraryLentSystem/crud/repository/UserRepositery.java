package libraryLentSystem.crud.repository;

import java.util.ArrayList;
import java.util.List;

import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignInResDto;
import libraryLentSystem.crud.entity.UserEntity;

public interface UserRepositery {
	
	List<UserEntity> USER_DATABASE_LIST = new ArrayList<>();
	
	boolean existById(String id);
	SignInResDto signIn(SignInReqDto dto);
	void signUp(UserEntity entity);
}
