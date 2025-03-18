package libraryLentSystem.crud.dto.book;

import java.util.Scanner;

public class BookLentReqDto {

	private String bookNumber;
	private String userId;
	public BookLentReqDto(String userId) {
		this.userId = userId;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("대여할 책 번호를 입력하세요 : ");
		bookNumber = sc.nextLine();
	}
	
	
	
	public String getBookNumber() {
		return bookNumber;
	}
	public String getUserId() {
		return userId;
	}
	
	
	
}
