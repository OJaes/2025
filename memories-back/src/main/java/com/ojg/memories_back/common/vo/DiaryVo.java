package com.ojg.memories_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.ojg.memories_back.common.entity.DiaryEntity;

import lombok.Getter;

@Getter
public class DiaryVo {
    private Integer diaryNumber;
    private String writeDate;
    private String title;
    private String weather;
    private String feeling;

    private DiaryVo(DiaryEntity diaryEntity){
        this.diaryNumber = diaryEntity.getDiaryNumber();
        this.writeDate = diaryEntity.getWriteDate();
        this.title = diaryEntity.getTitle();
        this.weather = diaryEntity.getWeather();
        this.feeling = diaryEntity.getFeeling();
    }

    public static List<DiaryVo> getList(List<DiaryEntity> diaryEntities){
        List<DiaryVo> list = new ArrayList<>();
        for(DiaryEntity diaryEntity : diaryEntities){
            DiaryVo diaryVo = new DiaryVo(diaryEntity);
            list.add(diaryVo);
        }
        return list;
    }
}
