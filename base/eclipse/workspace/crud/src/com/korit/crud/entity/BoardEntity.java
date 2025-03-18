package com.korit.crud.entity;

import java.time.LocalDate;

import com.korit.crud.dto.board.InsertBoardRequireDto;

public class BoardEntity {

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	private int boardNumber;
	private String title;
	private String content;
	private String userId;
	private String userNickname;
	private String createDate;
	
	public BoardEntity(InsertBoardRequireDto dto, String userId) {
		this.title = dto.getTitle();
		this.content = dto.getContent();
		this.userId = userId;
		this.createDate = LocalDate.now().toString();
	}
	
	public BoardEntity(int boardNumber, String title, String nickname, String createDate) {
		this.boardNumber = boardNumber;
		this.title = title;
		this.userNickname = nickname;
		this.createDate = createDate;
	}
	
	public BoardEntity() {
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getUserId() {
		return userId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
}
