package com.ojg.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojg.memories_back.common.entity.MemoryTestEntity;
import com.ojg.memories_back.common.entity.pk.MemoryTestPk;

@Repository
public interface MemoryTestRpository extends JpaRepository<MemoryTestEntity, MemoryTestPk>{
    
}
