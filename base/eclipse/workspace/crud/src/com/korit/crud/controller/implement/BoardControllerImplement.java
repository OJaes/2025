package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.BoardController;
import com.korit.crud.dto.board.InsertBoardRequireDto;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.service.BoardService;

public class BoardControllerImplement implements BoardController {

	private final BoardService boardService;
	
	public BoardControllerImplement(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public void insertBoard(InsertBoardRequireDto boardRequireDto) {
		String userId = CrudApplication.SESSION;
		if(userId == null) {
			System.out.println("로그인되어있지 않습니다.");
			return;
		}
		boardService.getBoardInfo(userId, boardRequireDto);
		
	}

	@Override
	public void viewBoardList() {
		String userId = CrudApplication.SESSION;
		if(userId == null) {
			System.out.println("로그인되어있지 않습니다.");
			return;
		}
		boardService.getBoardListInfo();
		
	}

	@Override
	public void viewBoard(int boardNum) {
		boardService.getBoard(boardNum);
		
	}

	@Override
	public void modifyBoard(int boardNum) {
		String userId = CrudApplication.SESSION;
		BoardEntity entity = boardService.validateBoard(boardNum, userId);
		if(entity == null) return;
		boardService.updateBoard(entity);
	}

	@Override
	public void deleteBoard(int boardNum) {
		String userId = CrudApplication.SESSION;
		BoardEntity entity = boardService.validateBoard(boardNum, userId);
		if(entity == null) return;
		boardService.deleteBoard(entity);
	}
}
