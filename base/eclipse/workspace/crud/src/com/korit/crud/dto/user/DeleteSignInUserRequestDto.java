package com.korit.crud.dto.user;

import java.util.Scanner;

public class DeleteSignInUserRequestDto {

	private String password;
	
	public DeleteSignInUserRequestDto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호를 입력하세요 : ");
		this.password = sc.nextLine();
		
		
	}
	
	public boolean validate() {
		if(password == null) {
			System.out.println("비밀번호를 입력하세요.");
			return false;
		}
		return true;
	}

	public String getPassword() {
		return password;
	}
	
	
}
