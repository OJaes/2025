package libraryLentSystem.crud.controller.impl;

import libraryLentSystem.crud.controller.BookController;
import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.dto.book.BookSearchReqDto;
import libraryLentSystem.crud.service.BookService;

public class BookControllerImpl implements BookController{

	private final BookService bookService;
	
	public BookControllerImpl(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Override
	public void searchBook(BookSearchReqDto bookSearchReqDto) {
		if(bookSearchReqDto == null) {
			System.out.println("오류 발생");
			return;
		}
		
		bookService.searchBookByCode(bookSearchReqDto);
	}

	@Override
	public void lentBook(BookLentReqDto bookLentReqDto) {
		if(bookLentReqDto == null) {
			System.out.println("오류 발생");
			return;
		}
		bookService.lentBookByCode(bookLentReqDto);
		
	}

	@Override
	public void returnBook(BookReturnDto bookReturnDto) {
		if(bookReturnDto == null) {
			System.out.println("오류 발생");
			return;
		}
		bookService.bookReturnByName(bookReturnDto);
	}

}
