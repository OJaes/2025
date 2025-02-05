package com.korit.crud.entity;

import com.korit.crud.dto.auth.SignUpRequestDto;

//7

// Entity : 저장소(에 들어가는 하나의 요소에 대한 객체) 객체
public class UserEntity {

	private String id;
	private String password;
	private String nickname;
	
	public UserEntity(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	
	public UserEntity(SignUpRequestDto dto) {
		this.id = dto.getId();
		this.password = dto.getPassword();
		this.nickname = dto.getNickname();
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	

	
}
