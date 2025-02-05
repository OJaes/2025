package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.UserController;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.service.UserService;

public class UserControllerImplement implements UserController{

	private final UserService service;
	
	public UserControllerImplement(UserService service) {
		this.service = service;
	}
	
	@Override
	public void viewUserInfo() {
		String userId = CrudApplication.SESSION;
		// 유효성 검사
		if(userId == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		service.getUserInfo(userId);
	}

	@Override
	public void patchSignInUser(PatchSignInUserRequestDto dto) {
		String id = CrudApplication.SESSION;
		if(dto == null || id == null) {
			System.out.println("오류 발생");
			return;
		}
		service.patchSignInUser(dto, id);
	}

	@Override
	public void deleteSignInUser(DeleteSignInUserRequestDto dto) {
		String id = CrudApplication.SESSION;
		if(dto == null || id == null) {
			System.out.println("오류 발생");
			return;
		}
		service.deleteSignInUser(dto, id);
		
	}

	
	

}
