package com.korit.crud;

import java.sql.Connection;
import java.util.Scanner;

import com.korit.crud.controller.AuthController;
import com.korit.crud.controller.BoardController;
import com.korit.crud.controller.UserController;
import com.korit.crud.controller.implement.AuthControllerImplement;
import com.korit.crud.controller.implement.BoardControllerImplement;
import com.korit.crud.controller.implement.UserControllerImplement;
import com.korit.crud.db.MySQLConnector;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.dto.board.InsertBoardRequireDto;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.repository.implement.BoardRepositoryImplement;
import com.korit.crud.repository.implement.UserRepositoryImplement;
import com.korit.crud.service.AuthService;
import com.korit.crud.service.BoardService;
import com.korit.crud.service.UserService;
import com.korit.crud.service.implement.AuthServiceImplement;
import com.korit.crud.service.implement.BoardServiceImplement;
import com.korit.crud.service.implement.UserServiceImplement;

//1
public class CrudApplication {

	public static String SESSION = null;
	
	public static void main(String[] args) {
	
		Connection connection = MySQLConnector.getInstance().getconnConnection();
		
		UserRepository repository = new UserRepositoryImplement(connection);
		AuthService authService = new AuthServiceImplement(repository);
		AuthController authController = new AuthControllerImplement(authService);
		
		UserService userService = new UserServiceImplement(repository);
		UserController userController = new UserControllerImplement(userService);
		
		BoardRepository boardRepository = new BoardRepositoryImplement(connection);
		BoardService boardService = new BoardServiceImplement(boardRepository);
		BoardController boardController = new BoardControllerImplement(boardService);
		
		Scanner sc = new Scanner(System.in);
		
//		MySQLConnector mySQLConnector = MySQLConnector.getInstance();
//		Connection connection = mySQLConnector.getconnConnection();
		
		
		
		while (true) {
			// 로그인 안되어있으면 작업(로그인, 회원가입)
			// 로그인 되어있으면 작업(정보 보기, 정보 수정, 정보 삭제)
			String job = SESSION == null ? "(로그인, 회원가입)" : "(정보 보기, 정보 수정, 정보 삭제, 게시판)";
			
			System.out.print("작업 " + job + " : ");
			String request = sc.nextLine();
			
			if (request.equals("exit")) break;
			
			if(request.equals("회원가입")) { 
				SignUpRequestDto requestDto = new SignUpRequestDto();
				authController.signUp(requestDto);
			}
			
			if(request.equals("로그인")) {
				SignInRequestDto dto = new SignInRequestDto();
				authController.signIn(dto);
			}
			
			if(!(SESSION == null) && request.equals("정보 보기")) {
				userController.viewUserInfo();
			}
			if(!(SESSION == null) && request.equals("정보 수정")) {
				PatchSignInUserRequestDto dto = new PatchSignInUserRequestDto();
				userController.patchSignInUser(dto);
			}
			if(!(SESSION == null) && request.equals("정보 삭제")) {
				DeleteSignInUserRequestDto dto = new DeleteSignInUserRequestDto();
				userController.deleteSignInUser(dto);
			}
			
			if(!(SESSION == null) && request.equals("게시판")) {
				job = "(작성, 리스트 보기, 상세 보기, 수정, 삭제)";
				System.out.print("작업 " + job + " : ");
				request = sc.nextLine();
				
				if(request.equals("작성")) {
					InsertBoardRequireDto dto = new InsertBoardRequireDto();
					boardController.insertBoard(dto);
				}
				if(request.equals("리스트 보기")) {
					boardController.viewBoardList();
				}
				if(request.equals("상세 보기")) {
					System.out.print("게시물 번호 : ");
					request = sc.nextLine();
					boardController.viewBoard(Integer.parseInt(request));
				}
				if(request.equals("수정")) {
					System.out.print("게시물 번호 : ");
					request = sc.nextLine();
					boardController.modifyBoard(Integer.parseInt(request));
				}
				if(request.equals("삭제")) {
					System.out.print("게시물 번호 : ");
					request = sc.nextLine();
					boardController.deleteBoard(Integer.parseInt(request));
				}
			}
			
			
		}
		
		sc.close();
	}

}