package libraryLentSystem.crud.controller.impl;

import java.util.Scanner;

import libraryLentSystem.crud.controller.MenuController;

public class MenuSelectImpl implements MenuController{
	Scanner sc = new Scanner(System.in);
	static String act = "";
	
	public MenuSelectImpl() {
		act = "";
	}
	
	@Override
	public String menuSelect(String session) {
		System.out.println("메뉴를 입력하세요");
		if(session == null) {
			System.out.println("로그인");
			System.out.println("회원가입");
		}
		System.out.println("도서 검색");
		if(!(session == null)) {
			System.out.println("도서 대여");
			System.out.println("도서 반납");			
		}
		System.out.println("프로그램 종료");
		System.out.print("메뉴 : ");
		act = sc.nextLine();
		return act;
	}

}
