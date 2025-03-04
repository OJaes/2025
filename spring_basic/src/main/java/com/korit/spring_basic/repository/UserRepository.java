package com.korit.spring_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.spring_basic.entity.UserEntity;
import java.util.List;



// user 테이블에 접근할 레파지토리
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    // SELECT * FROM user WHERE user_id = ?
    UserEntity findByUserId(String userId);
    UserEntity findByUserTelNumber(String userTelNumber);

    boolean existsByUserId(String userId);
    boolean existsByUserTelNumber(String userTelNumber);
}
