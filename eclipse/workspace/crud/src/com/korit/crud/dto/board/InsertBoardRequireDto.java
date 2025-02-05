package com.korit.crud.dto.board;

import java.util.Scanner;

public class InsertBoardRequireDto {

	private String title;
	private String content;
	
	
	public InsertBoardRequireDto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("제목 : ");
		title = sc.nextLine();
		System.out.print("내용 : ");
		content = sc.nextLine();
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	boolean validate() {
		if(isNull()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNull() {
		return title != null && content != null;
	}
	
	
	
}
