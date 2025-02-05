package libraryLentSystem.crud.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryLentSystem.crud.dto.book.BookLentReqDto;
import libraryLentSystem.crud.dto.book.BookReturnDto;
import libraryLentSystem.crud.entity.BookEntity;
import libraryLentSystem.crud.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository {

	private final Connection connection;
	
	public BookRepositoryImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<BookEntity> getBookList(String searchCode, String searchContent) {
		
		final String SQL = "SELECT * FROM book WHERE " + searchCode + " LIKE ?";
		
		List<BookEntity> bookLists = new ArrayList<BookEntity>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//			preparedStatement.setString(1, searchCode);
			preparedStatement.setString(1, "%"+searchContent+"%");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				BookEntity entity = new BookEntity( resultSet.getInt("book_code"),
													resultSet.getString("name"),
													resultSet.getString("author"), 
													resultSet.getString("publish_company"),
													resultSet.getString("type"), 
													resultSet.getBoolean("lent"));
				bookLists.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bookLists;
	}

	@Override
	public boolean checkBookLent(String bookNumber) {

		final String SQL = "SELECT lent FROM book WHERE book_code = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, bookNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) return resultSet.getBoolean("lent");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void lentBookByCode(BookLentReqDto dto) {
		final String SQL = "UPDATE book SET lent = true, lent_user_id = ? WHERE book_code = ?";
		final String SQL2 = "UPDATE user SET lent_count = lent_count + 1 WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setString(1, dto.getUserId());
			statement.setString(2, dto.getBookNumber());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL2);
			preparedStatement.setString(1, dto.getUserId());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("대여되었습니다.");
	}

	@Override
	public boolean checkLentedBookUser(BookReturnDto bookReturnDto) {
		final String SQL = "SELECT lent FROM book WHERE lent_user_id = ? AND lent = true AND name = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, bookReturnDto.getUserId());
			preparedStatement.setString(2, bookReturnDto.getBookName());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void ReturnBook(BookReturnDto bookReturnDto) {

		final String SQL = "UPDATE book SET lent = false, lent_user_id = null";
		final String SQL2 = "UPDATE user SET lent_count = lent_count - 1 WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.execute();
			PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);
			preparedStatement2.setString(1, bookReturnDto.getUserId());
			preparedStatement2.execute();
			System.out.println("반납이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean checkUserLentCount(String userId) {
		
		final String SQL = "SELECT lent_count FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt("lent_count") > 3;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("에러 발생");
		return false;
	}
	
}
