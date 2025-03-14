package com.ojg.memories_back.common.entity;

import com.ojg.memories_back.common.entity.pk.ConcentrationTestPk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="concentrationTest")
@Table(name="conceentrationTest ")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ConcentrationTestPk.class)
public class ConcentrationTestEntity {
    
    @Id
    private String userId;
    @Id
    private Integer sequence;
    private Integer measurementScore;
    private Integer errorCount;
    private String testDate;
    private Integer scoreGap;
    private Integer errorGap;
}
