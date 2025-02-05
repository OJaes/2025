package libraryLentSystem.crud.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryLentSystem.crud.dto.auth.SignInReqDto;
import libraryLentSystem.crud.dto.auth.SignInResDto;
import libraryLentSystem.crud.entity.UserEntity;
import libraryLentSystem.crud.repository.UserRepositery;

public class UserRepositeryImpl implements UserRepositery{

	private final Connection connection;
	
	public UserRepositeryImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean existById(String id) {
		
		final String SQL = "SELECT id FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	}

	@Override
	public void signUp(UserEntity entity) {
		final String SQL = "INSERT INTO user VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, entity.getId());
			preparedStatement.setString(2, entity.getPw());
			preparedStatement.setString(3, entity.getName());
			preparedStatement.setString(4, entity.getBirth());
			preparedStatement.setString(5, entity.getPhoneNumber());
			preparedStatement.setString(6, entity.getAddress());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public SignInResDto signIn(SignInReqDto dto) {

		final String SQL = "SELECT id, password FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, dto.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				SignInResDto resDto = new SignInResDto(resultSet.getString("id"), resultSet.getString("password"));
				return resDto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
	}

}
