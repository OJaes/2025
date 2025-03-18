package libraryLentSystem.crud.dto.book;

import java.util.Scanner;

public class BookSearchReqDto {

	private int searchCode;
	private String bookName;
	private String bookAuthor;
	private String publishCompany;
	private String bookType;
	
	public BookSearchReqDto() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("검색 유형을 입력해주세요 (책 이름, 저자, 출판사, 책 유형) : ");
		String searchType = sc.nextLine();
		
		switch (searchType) {
		case "책 이름": {
			searchCode = 1;
			System.out.print("책 이름을 입력해주세요 : ");
			this.bookName = sc.nextLine();
			break;
		}
		case "저자":
			searchCode = 2;
			System.out.println("저자를 입력해주세요 : ");
			this.bookAuthor = sc.nextLine();
			break;
		case "출판사" :
			searchCode = 3;
			System.out.print("출판사를 입력해주세요 : ");
			this.publishCompany = sc.nextLine();
			break;
		case "책 유형" :
			searchCode = 4;
			System.out.println("유형을 입력해주세요 : ");
			this.bookType = sc.nextLine();
			break;
		default:
			System.out.println("유효하지 않은 검색입니다.");
		}
		
		
	}

	public int getSearchCode() {
		return searchCode;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getPublishCompany() {
		return publishCompany;
	}

	public String getBookType() {
		return bookType;
	}
	
	
}
