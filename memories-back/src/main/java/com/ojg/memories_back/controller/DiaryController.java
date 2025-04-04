package com.ojg.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojg.memories_back.common.dto.request.diary.PatchDiaryRequestDto;
import com.ojg.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.ojg.memories_back.common.dto.response.auth.ResponseDto;
import com.ojg.memories_back.common.dto.response.diary.GetDiaryResponseDto;
import com.ojg.memories_back.common.dto.response.diary.GetMyDiaryResponseDto;
import com.ojg.memories_back.handler.OAuth2SuccessHandler;
import com.ojg.memories_back.service.DiarySerivce;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final OAuth2SuccessHandler OAuth2SuccessHandler;
  
  private final DiarySerivce diarySerivce;



  @PostMapping({"","/"})
  public ResponseEntity<ResponseDto> postDiary(@RequestBody @Valid PostDiaryRequestDto requestBody, 
  @AuthenticationPrincipal String userId) {
      ResponseEntity<ResponseDto> response = diarySerivce.postDiary(requestBody, userId);
      return response;
  }
  

  @GetMapping("/my")
  public ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(@AuthenticationPrincipal String userId) {
    ResponseEntity<? super GetMyDiaryResponseDto> response = diarySerivce.getMyDiary(userId);
    return response;
  }
  
  @GetMapping("/{diaryNumber}")
  public ResponseEntity<? super GetDiaryResponseDto> getDiary(@PathVariable("diaryNumber") Integer diaryNumber) {
      ResponseEntity<? super GetDiaryResponseDto> response = diarySerivce.getDiary(diaryNumber);
      return response;
  }
  
  @PatchMapping("/{diaryNumber}")
  public ResponseEntity<ResponseDto> patchDiary(
    @RequestBody @Valid PatchDiaryRequestDto requestBody,
    @PathVariable("diaryNumber") Integer diaryNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diarySerivce.patchDiary(requestBody, diaryNumber, userId);
    return response;
  }


  @DeleteMapping("/{diaryNumber}")
  public ResponseEntity<ResponseDto> deleteDiary(
    @PathVariable("diaryNumber") Integer diaryNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diarySerivce.deleteDiary(diaryNumber, userId);
    return response;
  }
}