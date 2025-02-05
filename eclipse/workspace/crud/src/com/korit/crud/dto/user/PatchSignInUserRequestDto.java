package com.korit.crud.dto.user;

import java.util.Scanner;

import com.korit.crud.CrudApplication;

public class PatchSignInUserRequestDto {

	private String nickname;
	
	public PatchSignInUserRequestDto() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("변경할 닉네임을 입력해주세요 : ");
		this.nickname = sc.nextLine();
		
	}
	
	
	
	public boolean validate() {
		if(nicknameValidate()) return true;
		return false;
	}
	
	
	private boolean nicknameValidate() {
		if(nickname.isBlank() || nickname.isEmpty()) {
			System.out.println("닉네임은 공백으로만 구성하거나 비어있을 수 없습니다.");
			return false;
		}
		return true;
		
	}

	public String getNickname() {
		return nickname;
	}

	
	
}
