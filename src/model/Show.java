package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
public class Show {
	
	public class Season{
		
		public class Episode{
			private long episodeId;
			private int number;
			private String name;
			private String plot;
			private LocalDateTime airingDate;
			private boolean isWached;
			private LinkedList<Comment> comments;
			private int voteCount;
			private HashSet<User> voters;
			private HashMap<String, User> friends; // username -> user
			
			private Episode(int number,long episodeId, String plot, String name, LocalDateTime airingDate, boolean isWached){
				this.number = number;
				this.isWached = false;
				comments = new LinkedList<Comment>();
				this.voters = new HashSet<>();
				friends = new HashMap<>();
				this.episodeId = episodeId;
			}
			
			public long getEpisodeId() {
				return episodeId;
			}
			
			public void setEpisodeId(long episodeId) {
				this.episodeId = episodeId;
			}
			
			public boolean getIsWached() {
				return this.isWached;
			}
			
			public void setIsWached() {
				this.isWached = true;
			}
			
			public void addComment(User user, String content, LocalDateTime date) {
				this.comments.add(new Comment(user, content, date));
			}
			
			public void getComments(){
				for (Comment comment : this.comments) {
					System.out.println(comment.getUser().getUserName() + " " + comment.getContent() + " " + comment.getDate());
				}
			}
			
			public double getRating(){
				return this.voteCount/this.voters.size();
			}
			
			public void vote(User user, int vote){
				if(!voters.contains(user)){
					this.voteCount += vote;
					voters.add(user);
				}
			}			
		}
		
		int number;
		long seasonId;
		TreeMap<Integer ,Episode> episodes;
		public Season(int number, long seasonId) {
			this.number = number;
			this.seasonId = seasonId;
			episodes = new TreeMap<Integer, Episode>();
		}
		
		public void addEpisode(int number,long episodeId, String plot, String name, LocalDateTime airingDate, boolean isWached){
			if(!this.episodes.containsKey(number)){
				this.episodes.put(number, new Episode(number, episodeId, plot, name, airingDate, isWached));
			}			
		}
		
		public TreeMap<Integer, Episode> getEpisodes(){
			return this.episodes;
		}
		
		public long getSeasonId() {
			return seasonId;
		}
	}
	
	private long showId;
	private String name;
	private String plot;
	private int voteCount;
	private HashSet<User> voters;
	private HashSet<User> followers;
	TreeMap<Integer, Season> seasons;
	private LinkedList<Comment> comments;
	
	public Show(String name, String plot, int voteCount) {
		this.name = name;
		this.plot = plot;
		seasons = new TreeMap<Integer, Season>();
		voters = new HashSet<User>();
		followers = new HashSet<User>();
		comments = new LinkedList<Comment>();
	}
	
	public void addSeason(int number, long id){
		if(!seasons.containsKey(number)){
			this.seasons.put(number, new Season(number, id));
		}
	}
	
	public int getVoteCount() {
		return voteCount;
	}
	
	public double getRating(){
		return this.voteCount/this.voters.size();
	}
	
	public void vote(User user, int vote){
		if(!voters.contains(user)){
			this.voteCount += vote;
			voters.add(user);
		}
	}
	
	public TreeMap<Integer, Season> getSeasons() {
		return seasons;
	}
	
	public long getShowId() {
		return showId;
	}
	
	public void setShowId(long showId) {
		this.showId = showId;
	}
	
	public String getShowName() {
		return name;
	}
	
	public void addComment(User user, String content, LocalDateTime date) {
		this.comments.add(new Comment(user, content, date));
	}
	
	public LinkedList<Comment> getComments(){
		return this.comments;
	}
	
	public String getPlot() {
		return plot;
	}
}
