package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.Connect;

public class User {
	private int id;
	private String username, password;
	
	Connect con = Connect.getConnection();
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	private User map(ResultSet rs) {
		int id;
		String username, password;

		try {
			id = rs.getInt("id");
			username = rs.getString("username");
			password = rs.getString("password");
			return new User(id, username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public User getUser(String username, String password) {
		String query = String.format("SELECT * FROM user WHERE username=? AND password=?");
		PreparedStatement preparedStatement = con.prepareStatement(query);
		con.resultSet = null;
		try {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			con.resultSet = preparedStatement.executeQuery();
			User user = null;
			if(con.resultSet.next()) {
				user = map(con.resultSet);
				return user;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
}
