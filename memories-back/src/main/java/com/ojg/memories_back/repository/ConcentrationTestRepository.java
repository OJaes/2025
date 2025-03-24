package com.ojg.memories_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojg.memories_back.common.entity.ConcentrationTestEntity;
import com.ojg.memories_back.common.entity.pk.ConcentrationTestPk;

@Repository
public interface ConcentrationTestRepository extends JpaRepository<ConcentrationTestEntity, ConcentrationTestPk> {

  Integer countByUserId(String userId);

  ConcentrationTestEntity findByUserIdAndSequence(String userId, Integer sequence);
  List<ConcentrationTestEntity> findByUserIdOrderBySequenceDesc(String userId);
  
}