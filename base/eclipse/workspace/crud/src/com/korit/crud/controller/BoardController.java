package com.korit.crud.controller;

import com.korit.crud.dto.board.InsertBoardRequireDto;

public interface BoardController {
	void insertBoard(InsertBoardRequireDto boardRequireDto);
	void viewBoardList();
	void viewBoard(int boardNum);
	void modifyBoard(int boardNum);
	void deleteBoard(int boardNum);
}
