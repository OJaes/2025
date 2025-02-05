package libraryLentSystem.crud.service.impl;

import java.util.List;

import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.dto.book.BookSearchReqDto;
import libraryLentSystem.crud.entity.BookEntity;
import libraryLentSystem.crud.repository.BookRepository;
import libraryLentSystem.crud.service.BookService;

public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void searchBookByCode(BookSearchReqDto dto) {
		
		String searchCode = null;
		String searchContent = null;
		switch(dto.getSearchCode()) {
		case 1 :
			searchCode = "name";
			searchContent = dto.getBookName();
			break;
		case 2 : 
			searchCode = "author";
			searchContent = dto.getBookAuthor();
			break;
		case 3:
			searchCode = "publish_Company";
			searchContent = dto.getPublishCompany();
			break;
		case 4:
			searchCode = "type";
			searchContent = dto.getBookType();
			break;
		}
		
		List<BookEntity> bookLists = bookRepository.getBookList(searchCode, searchContent);
		
		System.out.println("책 번호 / 이름 / 저자 / 출판사 / 도서 장르 / 대여 여부");
		for(BookEntity books : bookLists) {
			System.out.print(books.getBookNumber() + " / ");
			System.out.print(books.getBookName() + " / ");
			System.out.print(books.getAuthor() + " / ");
			System.out.print(books.getPublishCompany() + " / ");
			System.out.print(books.getBookType() + " / ");
			System.out.println(books.getBookLent());
		}
		return ;
	}

	@Override
	public void lentBookByCode(BookLentReqDto dto) {
		if(bookRepository.checkBookLent(dto.getBookNumber())) {
			System.out.println("이미 대여된 도서입니다.");
			return;
		}
		if(bookRepository.checkUserLentCount(dto.getUserId())) {
			System.out.println("대여는 최대 3권입니다.");
		}
		bookRepository.lentBookByCode(dto);
	}

	@Override
	public void bookReturnByName(BookReturnDto dto) {
		if(!bookRepository.checkLentedBookUser(dto)) {
			System.out.println("대여하지 않은 도서입니다.");
			return;
		}
		bookRepository.ReturnBook(dto);
	}
	
}
