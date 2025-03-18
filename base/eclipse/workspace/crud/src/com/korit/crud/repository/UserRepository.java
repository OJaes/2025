package com.korit.crud.repository;

import java.util.ArrayList;
import java.util.List;

import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.entity.UserEntity;

//8

// repository : 데이터베이스 작업을 위한 모듈(레이어)
// 데이터베이스에 삽입, 조회, 수정, 삭제 작업 처리
public interface UserRepository {
	List<UserEntity> DATABASE_LIST = new ArrayList<>();
	
	void save(UserEntity entity);
	UserEntity findById(String id);
	boolean existsById(String id);
	
	void updateByNickname(String id, String nickname);
	void deleteById(String id);
	void deleteOne(UserEntity entity);
}
