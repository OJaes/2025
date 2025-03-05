package com.korit.spring_basic.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.spring_basic.dto.GetUserResponseDto;
import com.korit.spring_basic.dto.PostUserRequestDto;
import com.korit.spring_basic.dto.ResponseDto;
import com.korit.spring_basic.entity.UserEntity;
import com.korit.spring_basic.repository.UserRepository;
import com.korit.spring_basic.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    
    public void queryMethod(){
        UserEntity userEntity = new UserEntity();
        // save(엔티티) : 인스턴스를 레코드로 저장하는 메서드
        // 만약 엔티티의 ID에 해당하는 데이터가 동일한 데이터가 테이블에 존재한다면 수정(덮어쓰기)
        // 만약 엔티티의 ID에 해당하는 데이터가 테이블에 존재하지 않는다면 삽입
        userRepository.save(userEntity);

        // saveAll(엔티티 컬렉션) : 컬렉션으로 관리되는 엔티티 인스턴스를 모두 저장
        List<UserEntity> entities = new ArrayList<>();
        userRepository.saveAll(entities);

        // findById(ID 데이터) : ID를 기준으로 조회
        // - 반환 타입이 Optional 타입으로 반환되기 때문에 불편하니 직접 쿼리 메서드를 작성하는게 나음음
        userEntity = userRepository.findById("아이디").get();

        // findAll(): 전체 레코드를 조회
        entities = userRepository.findAll();

        // existsById(ID 데이터) : 아이디 기준으로 레코드 존재 여부 반환
        boolean existed = userRepository.existsById("아이디");

        // deleteById(ID 데이터) : 아이디 기준으로 레코드 삭제
        userRepository.deleteById("아이디");
        // delete(엔티티) : 해당 엔티티 레코드를 삭제
        userRepository.delete(userEntity);
        // deleteAll(엔티티 컬렉션) : 해당 엔티티 리스트 삭제
        userRepository.deleteAll();
    }
    
    @Override
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {
        try{
    
            
            // unique값이 맞는지 확인(userId,telNumber)
            // UserEntity entity = userRepository.findByUserId(dto.getUserId());
        
            // if(userRepository.findByUserId(dto.getUserId()) != null){
        boolean existsByUserId = userRepository.existsByUserId(dto.getUserId());
        if(existsByUserId){ResponseDto.duplicatedId();}
        // if(userRepository.findByUserTelNumber(dto.getUserTelNumber()) != null){
            boolean existsByUserTelNumber = userRepository.existsByUserTelNumber(dto.getUserTelNumber());
            if(existsByUserTelNumber){ResponseDto.duplicatedTelNumber();}
            
            // builder 패턴 : 객체 생성 과정에 멤버 변수 별로 객체를 구성한 후 객체를 생성할 수 있도록 도움을 주는 생성 패턴
            // 가독성 향상, 객체 불변성 보장(1회용 setter이라 생각하면 됨)
            // UserEntity userEntity = new UserEntity().builder()
            //                                         .userId(dto.getUserId())
            //                                         .userPassword(dto.getUserPassword())
            //                                         .userName(dto.getUserName())
            //                                         .userTelNumber(dto.getUserTelNumber())
            //                                         .userAddress(dto.getUserAddress())
            //                                         .build();

            // UserEntity userEntity = new UserEntity(dto.getUserId(),dto.getUserPassword(),dto.getUserName(),dto.getUserAddress(),dto.getUserTelNumber());
            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);
            
        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
            // ResponseDto response = new ResponseDto("SU","Success.");
            return ResponseDto.success(HttpStatus.CREATED);
        }

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String userId) {
        UserEntity userEntity = null;
        try {
            userEntity = userRepository.findByUserId(userId);
            if(userEntity == null) return ResponseDto.noExistUser();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<ResponseDto> deleteUser(String userId) {

        try {
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity == null) return ResponseDto.noExistUser();
            userRepository.delete(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success(HttpStatus.OK);
    }
        
    }
    