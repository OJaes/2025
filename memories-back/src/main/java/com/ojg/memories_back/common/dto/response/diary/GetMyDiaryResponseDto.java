package com.ojg.memories_back.common.dto.response.diary;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ojg.memories_back.common.dto.response.auth.ResponseDto;
import com.ojg.memories_back.common.entity.DiaryEntity;
import com.ojg.memories_back.common.vo.DiaryVo;

import lombok.Getter;

@Getter
public class GetMyDiaryResponseDto extends ResponseDto{
    private List<DiaryVo> diaries;
    
    private GetMyDiaryResponseDto(List<DiaryEntity> diaryEntities){
        this.diaries = DiaryVo.getList(diaryEntities);
    }

    public static ResponseEntity<GetMyDiaryResponseDto> success(List<DiaryEntity> diaryEntities){
        GetMyDiaryResponseDto body = new GetMyDiaryResponseDto(diaryEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
