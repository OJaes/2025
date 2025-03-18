package libraryLentSystem.crud.dto.book;

import java.util.Scanner;

public class BookReturnDto {
	private String userId;
	private String bookName;
	public String getUserId() {
		return userId;
	}
	public String getBookName() {
		return bookName;
	}
	public BookReturnDto(String userId) {
		this.userId = userId;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반납할 도서 명을 입력하세요 : ");
		bookName = sc.nextLine();
	}
	
	
}
