package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
	Connection con;
	public Statement stat;
	public ResultSet resultSet;
	static Connect connect;

	public Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitas", "root", "");
			// create statement
			stat = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized Connect getConnection() {
		if(connect == null) {
			connect = new Connect();
		}
		return connect;
	}

	public ResultSet execQuery(String query) {
		try {
			resultSet = stat.executeQuery(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}

	public void executeUpdate(String query) {
		try {
			stat.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement prepareStatement(String query) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
}
