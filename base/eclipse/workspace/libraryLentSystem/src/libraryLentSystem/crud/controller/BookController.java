package libraryLentSystem.crud.controller;

import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.dto.book.BookSearchReqDto;

public interface BookController {

	void searchBook(BookSearchReqDto bookSearchReqDto);
	void lentBook(BookLentReqDto bookLentReqDto);
	void returnBook(BookReturnDto bookReturnDto);
	
}
