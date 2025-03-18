package libraryLentSystem.crud;

import java.sql.Connection;
import java.util.Scanner;


import libraryLentSystem.crud.controller.AuthController;
import libraryLentSystem.crud.controller.BookController;
import libraryLentSystem.crud.controller.MenuController;
import libraryLentSystem.crud.controller.impl.AuthControllerImple;
import libraryLentSystem.crud.controller.impl.BookControllerImpl;
import libraryLentSystem.crud.controller.impl.MenuSelectImpl;
import libraryLentSystem.crud.db.MySQLConnector;
import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignUpReqDto;
import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.dto.book.BookSearchReqDto;
import libraryLentSystem.crud.repository.BookRepository;
import libraryLentSystem.crud.repository.UserRepositery;
import libraryLentSystem.crud.repository.impl.BookRepositoryImpl;
import libraryLentSystem.crud.repository.impl.UserRepositeryImpl;
import libraryLentSystem.crud.service.AuthService;
import libraryLentSystem.crud.service.BookService;
import libraryLentSystem.crud.service.impl.AuthServiceImpl;
import libraryLentSystem.crud.service.impl.BookServiceImpl;

public class CrudApplication {

	public static String SESSION = null;

	public static void main(String[] args) {
		
		
		Connection connection = MySQLConnector.getInstance().getconnConnection();
		
		MenuController menuController = new MenuSelectImpl();
		
		UserRepositery repositery = new UserRepositeryImpl(connection);
		AuthService authService = new AuthServiceImpl(repositery);
		AuthController authController = new AuthControllerImple(authService);
		
		BookRepository bookRepository = new BookRepositoryImpl(connection);
		BookService bookService = new BookServiceImpl(bookRepository);
		BookController bookController = new BookControllerImpl(bookService);
		
		String act;
		
		while(true) {
			act = "";
			try {
				act = menuController.menuSelect(SESSION);				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			switch(act) {
			case "프로그램 종료":				
				System.out.println("프로그램을 종료합니다.");
				return;
			case "로그인":
				// 로그인
				SignInReqDto signInDto = new SignInReqDto();
				authController.signIn(signInDto);
				break;
			case "회원가입":
				//회원가입
				SignUpReqDto signUpDto = new SignUpReqDto();
				authController.signUp(signUpDto);
				break;
			case "도서 검색":
				//도서검색
				BookSearchReqDto bookSearchDto = new BookSearchReqDto();
				bookController.searchBook(bookSearchDto);
				break;
			case "도서 대여":
				//도서대여
				BookLentReqDto bookLentReqDto = new BookLentReqDto(SESSION);
				bookController.lentBook(bookLentReqDto);
				break;
			case "도서 반납":
				//도서반납
				BookReturnDto bookReturnDto = new BookReturnDto(SESSION);
				bookController.returnBook(bookReturnDto);
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
				break;
			}

			
		}

	}

}
