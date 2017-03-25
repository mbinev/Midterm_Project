package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

import model.Show;
import model.User;

public class ShowDAO {
	
	private static ShowDAO instance;
	private static final HashMap<String, Show> allShows = new HashMap<>(); //showName  - > show
	
	
	
	private ShowDAO() {
	}
	
	public static synchronized ShowDAO getInstance(){
		if(instance == null){
			instance = new ShowDAO();
		}
		return instance;
	}
	
	public synchronized void addShow(Show s) throws SQLException {
		String sql = "INSERT INTO shows	(name, plot, vote_count) VALUES(?, ?, ?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, s.getShowName());
		st.setString(2, s.getPlot());
		st.setInt(3, s.getVoteCount());
		st.execute();
		ResultSet rs = st.getGeneratedKeys();
		rs.next();
		s.setShowId(rs.getLong(1));
		System.out.println(s.getShowId());
		getAllShows().put(s.getShowName(), s);
	}
	
	public synchronized void addSeason(Show s, int seasonNumber) throws SQLException {
		String sql = "INSERT INTO seasons (number, show_id) VALUES(?, ?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, seasonNumber);
		st.setLong(2, getAllShows().get(s.getShowName()).getShowId());
		st.execute();
		ResultSet rs = st.getGeneratedKeys();
		rs.next();
		getAllShows().get(s.getShowName()).addSeason(seasonNumber, rs.getLong(1));
	}
	
	public synchronized void addEpisode(Show s, int seasonNumber, int number, String name,
			String plot, LocalDateTime airingDate, boolean isWached) throws SQLException {
		String sql = "INSERT INTO episodes (number, name, plot, airingDate, isWached, season_id) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
		st.setInt(1, number);
		st.setString(2, name);
		st.setString(3, plot);
		st.setTimestamp(4, Timestamp.valueOf(airingDate));
		st.setBoolean(5, isWached);
		System.out.println(s.getShowId());
		st.setLong(6, s.getSeasons().get(seasonNumber).getSeasonId());
		st.executeUpdate();
		getAllShows().get(s.getShowName()).getSeasons().get(seasonNumber).addEpisode(seasonNumber, s.getShowId(), plot, name, airingDate, isWached);
	}
	
	public HashMap<String, Show> getAllShows() throws SQLException{
		if(allShows.isEmpty()){
			String sql = "SELECT show_id, name, plot, vote_count FROM shows";
			PreparedStatement statement = DBManager.getInstance().getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Show s = new Show(rs.getString("name"), rs.getString("plot"),
						rs.getInt("vote_count"));
				s.setShowId(rs.getLong("show_id"));
				allShows.put(s.getShowName(), s);
				String sql1 = "SELECT season_id, number FROM seasons WHERE show_id = " + s.getShowId();
				PreparedStatement st1 = DBManager.getInstance().getConnection().prepareStatement(sql1);
				ResultSet rs1 = st1.executeQuery();
				while(rs1.next()){
					long l = rs1.getLong("season_id");
					int n = rs1.getInt("number");
					s.addSeason(n, l);
					String sql2 = "SELECT episode_id, number, name, plot, airingDate, isWached FROM episodes WHERE season_id = " + l;
					PreparedStatement st2 = DBManager.getInstance().getConnection().prepareStatement(sql2);
					ResultSet rs2 = st2.executeQuery();
					while(rs2.next()){
						s.getSeasons().get(n).addEpisode(rs2.getInt("number"), rs.getLong("episode_id"), rs2.getString("plot"),
								rs2.getString("name"), rs2.getTimestamp("airingDate").toLocalDateTime(), rs2.getBoolean("isWached"));
					}
				}
			}
		}
		return allShows;
	}
}
