package com.korit.crud.controller;

import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserController {

	void viewUserInfo();
	void patchSignInUser(PatchSignInUserRequestDto dto);
	void deleteSignInUser(DeleteSignInUserRequestDto dto);
}
