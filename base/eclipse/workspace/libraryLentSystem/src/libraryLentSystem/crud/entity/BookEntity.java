package libraryLentSystem.crud.entity;

public class BookEntity {

	private int bookNumber;
	private String bookName;
	private String author;
	private String publishCompany;
	private String bookType;
	private String bookLent;
	
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublishCompany() {
		return publishCompany;
	}
	public String getBookType() {
		return bookType;
	}
	public String getBookLent() {
		return bookLent;
	}
	
	
	public int getBookNumber() {
		return bookNumber;
	}
	public BookEntity(int bookNumber, String bookName, String author, String publishCompany, String bookType, boolean bookLent) {
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.publishCompany = publishCompany;
		this.bookType = bookType;
		this.bookLent = bookLent ? "대여 불가" : "대여 가능";
	}
	
	
	
}
