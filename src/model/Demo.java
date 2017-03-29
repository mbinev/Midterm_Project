package model;

import java.sql.SQLException;
import java.time.LocalDateTime;

import model.dao.ShowDAO;
import model.dao.UserDAO;

public class Demo {
	public static void main(String[] args) {
		
		try {
			User u = UserDAO.getInstance().getAllUsers().get("daswhat");
			Show s = ShowDAO.getInstance().getAllShows().get("Walking dead");
			UserDAO.getInstance().addToMyFollowing(u, s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
