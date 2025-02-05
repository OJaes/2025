package com.korit.crud.service.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.UserService;

public class UserServiceImplement implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void getUserInfo(String userId) {
		UserEntity entity = userRepository.findById(userId);
		if(entity == null) {
			System.out.println("오류 발생");
			return;
		}
		System.out.println("ID : " + entity.getId());
		System.out.println("Nickname : " + entity.getNickname());
		
	}

	@Override
	public void patchSignInUser(PatchSignInUserRequestDto dto, String id) {
		boolean existsId = userRepository.existsById(id);
		if(!existsId) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		userRepository.updateByNickname(id, dto.getNickname());
		System.out.println("성공했습니다.");
		
	}

	@Override
	public void deleteSignInUser(DeleteSignInUserRequestDto dto, String id) {
		boolean existsId = userRepository.existsById(id);
		if(!existsId) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		UserEntity entity = userRepository.findById(id);
		if(!dto.getPassword().equals(entity.getPassword())) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		userRepository.deleteOne(entity);
		System.out.println("회원 탈퇴되었습니다.");
		
	}


}
