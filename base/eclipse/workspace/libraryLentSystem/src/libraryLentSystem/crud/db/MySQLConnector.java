package libraryLentSystem.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConnector {
	private static MySQLConnector instance;
	public Connection connection = null;
	
	private final String URL = "jdbc:mysql://127.0.0.1:3306/library";
	private final String USER = "lib_developer";
	private final String PASSWORD = "qwer1234";
	
	private MySQLConnector () {
		try {
			// JDBC MySQL 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DATABASE 연결
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MySQLConnector getInstance() {
		if(instance == null) {
			// synchronized : 비동기 처리(멀티 스레드)에 대해 동기 처리가 가능하도록 함
			synchronized (MySQLConnector.class) {
				if(instance == null) {
					instance = new MySQLConnector();
				}
			}
		}
		// 비동기 처리를 하면 바로 instance가 값을 안받고 넘어감
		return instance;
	}
	
	public Connection getconnConnection() {
		return connection;
	}
}
