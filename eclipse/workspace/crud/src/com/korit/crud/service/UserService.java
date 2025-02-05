package com.korit.crud.service;

import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserService {

	void getUserInfo(String userId);
	void patchSignInUser(PatchSignInUserRequestDto dto, String id);
	void deleteSignInUser(DeleteSignInUserRequestDto dto, String id);
	
}
