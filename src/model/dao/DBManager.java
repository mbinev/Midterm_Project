package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class DBManager {
	private static DBManager instance;
	private static final String DB_IP = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "tms";
	private static final String DB_USER = "";
	private static final String DB_PASS = "";
	private Connection connection = null;
	
	private DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem loading the driver!");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
		}
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms?user=user&password=user");
		} catch (SQLException e) {
			System.out.println("Unable to connect to Database" + e.getMessage());
		}
		
	}
	
	public static synchronized DBManager getInstance(){
		if(instance == null){
			instance = new DBManager();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
