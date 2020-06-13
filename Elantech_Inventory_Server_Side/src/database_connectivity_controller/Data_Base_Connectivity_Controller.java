package database_connectivity_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data_Base_Connectivity_Controller {

	private Connection connection;
	
	public void connectToDataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/kandptrux?useSSL=false",
					"root", "admin");
			setConnection(connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			setConnection(null);
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
