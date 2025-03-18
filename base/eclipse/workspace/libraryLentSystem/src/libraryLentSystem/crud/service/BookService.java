package libraryLentSystem.crud.service;

import java.util.List;

import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.dto.book.BookSearchReqDto;

public interface BookService {

	void searchBookByCode(BookSearchReqDto dto);
	void lentBookByCode(BookLentReqDto dto);
	void bookReturnByName(BookReturnDto dto);
	
}
