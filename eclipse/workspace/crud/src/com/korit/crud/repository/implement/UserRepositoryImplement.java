package com.korit.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.korit.crud.CrudApplication;
import com.korit.crud.db.MySQLConnector;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository{

	private final Connection connection;
	
	public UserRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean existsById(String id) {
		
		final String SQL = "SELECT * FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			// 결과물은 executeQuery를 통해 가져온다
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(id.equals(resultSet.getString("id"))) return true;
				// sql에서 index는 1부터 시작함
//				if(id.equals(resultSet.getString(1))) return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
//		for(UserEntity entity : DATABASE_LIST) {
//			if(entity.getId().equals(id)) return true;
//		}
//		return false;
	}

	@Override
	public void save(UserEntity entity) {
		
		final String SQL = "INSERT INTO user VALUES(?,?,?)";
		
		// preparestatement : sql의 빈 쿼리 생성이라 생각하면 됨
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1,entity.getId());
			preparedStatement.setString(2,entity.getPassword());
			preparedStatement.setString(3,entity.getNickname());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		DATABASE_LIST.add(entity);
	}

	@Override
	public UserEntity findById(String id) {
		
		final String SQL = "SELECT * FROM user WHERE id = ?";
		UserEntity entity = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if(resultSet.getString("id").equals(id)) {
					String dbId = resultSet.getString("id");
					String dbPw = resultSet.getString("password");
					String dbNickname = resultSet.getString("nickname");
					entity = new UserEntity(dbId,dbPw,dbNickname);
					return entity;
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
//		for(UserEntity entity : DATABASE_LIST) {
//			if(id.equals(entity.getId())) {
//				return entity;
//			}
//		}
//		return null;
		
	}

	@Override
	public void updateByNickname(String id, String nickname) {
//		UserEntity entity = findById(id);
//		int idx = DATABASE_LIST.indexOf(entity);
//		entity.setNickname(nickname);
//		DATABASE_LIST.set(idx, entity);
		
//		for(UserEntity entity : DATABASE_LIST) {
//			if(entity.getId().equals(id)) {
//				entity.setNickname(nickname);
//			}
//		}
		
		final String SQL = "UPDATE user SET nickname = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, nickname);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(String id) {
//		UserEntity entity = findById(id);
		
//		DATABASE_LIST.remove(entity);
//		CrudApplication.SESSION = null;
		
		final String SQL = "DELETE FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			CrudApplication.SESSION = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOne(UserEntity userEntity) {
		String id = userEntity.getId();
		this.deleteById(id);
	}
	

}
