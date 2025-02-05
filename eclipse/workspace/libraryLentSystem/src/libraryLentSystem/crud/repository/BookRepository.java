package libraryLentSystem.crud.repository;

import java.util.List;

import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.entity.BookEntity;

public interface BookRepository {

	List<BookEntity> getBookList (String searchCode, String searchContent);
	boolean checkBookLent(String bookNumber);
	void lentBookByCode(BookLentReqDto dto);
	boolean checkLentedBookUser(BookReturnDto bookReturnDto);
	void ReturnBook(BookReturnDto bookReturnDto);
	boolean checkUserLentCount(String userId);
}
