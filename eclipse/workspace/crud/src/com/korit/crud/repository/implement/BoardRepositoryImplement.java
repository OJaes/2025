package com.korit.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.korit.crud.CrudApplication;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.repository.BoardRepository;

public class BoardRepositoryImplement implements BoardRepository {

	private final Connection connection;
	
	public BoardRepositoryImplement(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertBoard(BoardEntity entity) {
		final String SQL = "INSERT INTO board (title, content, user_id, create_date) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, entity.getTitle());
			preparedStatement.setString(2, entity.getContent());
			preparedStatement.setString(3, entity.getUserId());
			preparedStatement.setString(4, entity.getCreateDate());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("작업에 성공하였습니다!");
		
	}

	@Override
	public List<BoardEntity> getBoardList() {
		final String SQL = "SELECT * FROM board_view ORDER BY board_number DESC";
		
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int boardNumber = resultSet.getInt("board_number");
				String title = resultSet.getString("title");
				String nickname = resultSet.getString("nickname");
				String createDate = resultSet.getString("create_date");
				BoardEntity entity = new BoardEntity(boardNumber, title, nickname, createDate);
				boardList.add(entity);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public BoardEntity getBoard(int boardNumber) {
		
		final String SQL = "SELECT * FROM board_view WHERE B.board_number = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, String.valueOf(boardNumber));
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String title = resultSet.getString("title");
				String nickname = resultSet.getString("nickname");
				String createDate = resultSet.getString("create_date");
				String content = resultSet.getString("content");
				String id = CrudApplication.SESSION;
				BoardEntity entity = new BoardEntity();
				entity.setTitle(resultSet.getString("title"));
				entity.setUserNickname(nickname);
				entity.setCreateDate(createDate);
				entity.setContent(content);
				entity.setUserId(id);
				entity.setBoardNumber(boardNumber);
				return entity;
			}
			System.out.println("존재하지 않는 게시물입니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void modifyBoard(BoardEntity entity) {
		final String SQL = "UPDATE board SET title = ?, content = ? WHERE board_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, entity.getTitle());
			preparedStatement.setString(2, entity.getContent());
			preparedStatement.setString(3, String.valueOf(entity.getBoardNumber()));
			preparedStatement.execute();
			System.out.println("수정에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBoard(BoardEntity entity) {
		final String SQL = "DELETE FROM board WHERE board_number = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, String.valueOf(entity.getBoardNumber()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
