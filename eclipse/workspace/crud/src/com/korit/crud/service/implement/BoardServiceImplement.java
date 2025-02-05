package com.korit.crud.service.implement;

import java.util.List;
import java.util.Scanner;

import com.korit.crud.dto.board.InsertBoardRequireDto;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.service.BoardService;

public class BoardServiceImplement implements BoardService {
	
	private final BoardRepository boardRepository;
	
	public BoardServiceImplement(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public void getBoardInfo(String userId, InsertBoardRequireDto dto) {
		if(dto == null || userId == null) {
			System.out.println("오류 발생");
			return;
		}
		BoardEntity entity = new BoardEntity(dto, userId);
		boardRepository.insertBoard(entity);
	}

	@Override
	public void getBoardListInfo() {
		List<BoardEntity> boardList = boardRepository.getBoardList();
		System.out.println("게시글 번호 / 게시물 제목 / 작성자 닉네임 / 작성일");
		for(BoardEntity board : boardList) {
			System.out.println(board.getBoardNumber() + " / " + board.getTitle() + " / " + board.getUserNickname() + " / " + board.getCreateDate());
		}
		
	}

	@Override
	public void getBoard(int boardNumber) {
		BoardEntity entity = boardRepository.getBoard(boardNumber);
		System.out.println("제목 : " + entity.getTitle());
		System.out.println("작성자 닉네임 : " + entity.getUserNickname());
		System.out.println("작성일 : " + entity.getCreateDate());
		System.out.println("내용 : " + entity.getContent());
	}

	@Override
	public void updateBoard(BoardEntity entity) {
		
		System.out.println("제목 : " + entity.getTitle());
		System.out.println("내용 : " + entity.getContent());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 제목 : ");
		String title = sc.nextLine();
		System.out.println("수정할 내용 : ");
		String content = sc.nextLine();
		
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setTitle(title);
		boardEntity.setContent(content);
		boardEntity.setBoardNumber(entity.getBoardNumber());
		
		boardRepository.modifyBoard(boardEntity);
	}

	@Override
	public BoardEntity validateBoard(int boardNumber, String userId) {
		BoardEntity entity = boardRepository.getBoard(boardNumber);
		if(entity == null) {
			return null;
		}
		if(!entity.getUserId().equals(userId)) {
			System.out.println("권한이 없습니다.");
			return null;
		}
		return entity;
	}

	@Override
	public void deleteBoard(BoardEntity entity) {
		boardRepository.deleteBoard(entity);
		System.out.println("삭제에 성공했습니다.");
		
	}
	
}
