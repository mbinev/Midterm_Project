package model;

import java.sql.SQLException;
import java.time.LocalDateTime;

import model.dao.ShowDAO;
import model.dao.UserDAO;

public class Demo {
	public static void main(String[] args) {
		Show s = new Show("Once upon a time", "Sci-fi time travel", 3);
		User u = new User("daswhat", 23, "bulgaria", "daswhat@what.com", "A23_fasD");
		try {
			UserDAO.getInstance().addToMyFollowing(UserDAO.getInstance().getAllUsers().get(u.getUserName()), ShowDAO.getInstance().getAllShows().get(s.getShowName()));
			ShowDAO.getInstance().addSeason(s, 3);
			ShowDAO.getInstance().addEpisode(s, 3, 7, "Guess whos back", "Tardis is the blue box in the back", LocalDateTime.now(), false);
		} catch (SQLException e) {
			System.out.println("ops"  + e.getMessage());
		}
	}
}
