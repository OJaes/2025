package com.korit.crud.repository;

import java.util.List;

import com.korit.crud.entity.BoardEntity;

public interface BoardRepository {	
	void insertBoard(BoardEntity entity);
	List<BoardEntity> getBoardList();
	BoardEntity getBoard(int boardNumber);
	void modifyBoard(BoardEntity entity);
	void deleteBoard(BoardEntity entity);
}
