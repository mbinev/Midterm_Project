package model;

import java.sql.SQLException;
import java.time.LocalDateTime;

import model.dao.ShowDAO;

public class Demo {
	public static void main(String[] args) {
		Show s = new Show("Doc Wshdofdssdsdasafsdaas", "Sci-fi time travel", 3);
		try {
			ShowDAO.getInstance().addShow(s);
			ShowDAO.getInstance().addSeason(s, 1);
			ShowDAO.getInstance().addEpisode(s, 1, 1, "Guess whos back", "Tardis is the blue box in the back", LocalDateTime.now(), false);
		} catch (SQLException e) {
			System.out.println("ops"  + e.getMessage());
		}
	}
}
