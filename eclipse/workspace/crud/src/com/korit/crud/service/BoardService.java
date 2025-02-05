package com.korit.crud.service;

import com.korit.crud.dto.board.InsertBoardRequireDto;
import com.korit.crud.entity.BoardEntity;

public interface BoardService {
	void getBoardInfo(String userId, InsertBoardRequireDto dto);
	void getBoardListInfo();
	void getBoard(int boardNumber);
	void updateBoard(BoardEntity entity);
	void deleteBoard(BoardEntity entity);
	
	BoardEntity validateBoard(int boardNumber, String userId);
}
