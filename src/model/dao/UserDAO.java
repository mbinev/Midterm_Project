package model.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDAO {
	
	private static UserDAO instance;
	private static final HashMap<String, User> allUsers = new HashMap<>(); //username  - > user
	
	private UserDAO() {
	}
	
	public static synchronized UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	public synchronized void addUser(User u) throws SQLException {
		String sql = "INSERT INTO users	(user_name, age, country, email, password) VALUES(?, ?, ?, ?, md5(?))";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, u.getUserName());
		st.setInt(2, u.getAge());
		st.setString(3, u.getCountry());
		st.setString(4, u.getEmail());
		st.setString(5, u.getPassword());
		st.execute();
		ResultSet rs = st.getGeneratedKeys();
		rs.next();
		u.setUserId(rs.getLong(1));
		getAllUsers().put(u.getUserName(), u);
	}
	
	public HashMap<String, User> getAllUsers() throws SQLException{
		if(allUsers.isEmpty()){
			String sql = "SELECT user_id, user_name, age, country, email, password FROM users";
			PreparedStatement statement = DBManager.getInstance().getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				User u = new User(rs.getString("user_name"), rs.getInt("age"),
						rs.getString("country"),rs.getString("email"), rs.getString("password"));
				u.setUserId(rs.getLong("user_id"));
				allUsers.put(u.getUserName(), u);
			}
		}
		return allUsers;
	}
	
	public synchronized boolean validLogin(String username, String password) throws SQLException{
		if(allUsers.containsKey(username)){
			MessageDigest m;
			try {
				m = MessageDigest.getInstance("MD5");
				m.update(password.getBytes());
				byte[] digest = m.digest();;
				String hashtext = DatatypeConverter.printHexBinary(digest).toUpperCase();
				return allUsers.get(username).getPassword().equals(hashtext);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("Problem with hashing the password.");
			}
		}
		return false;
	}
}
