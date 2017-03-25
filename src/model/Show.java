package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
public class Show {
	
	public class Season{
		
		public class Episode{
			private int number;
			private String name;
			private String plot;
			private LocalDateTime airingDate;
			private boolean isWached;
			private LinkedList<Comment> comments;
			private int voteCount;
			private HashSet<User> voters;
			
			private Episode(int number,long episodeId, String plot, String name, LocalDateTime airingDate, boolean isWached){
				this.number = number;
				this.isWached = false;
				comments = new LinkedList<Comment>();
				this.voters = new HashSet<>();
			}
			
			public boolean getIsWached() {
				return this.isWached;
			}
			
			public void setIsWached() {
				this.isWached = true;
			}
			
			public void addComment(User user, String content) {
				this.comments.add(new Comment(user, content));
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
			}else{
				System.out.println("There is already an episode " + number + " in this season!");
			}			
		}
		
		public TreeMap<Integer, Episode> getEpisode(){
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
		}else{
			System.out.println("This show has already a season " + number);
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
	
	public void addComment(User user, String content) {
		this.comments.add(new Comment(user, content));
	}
	
	public void getComments(){
		for (Comment comment : comments) {
			System.out.println(comment.getUser().getUserName() + " " + comment.getContent() + " " + comment.getDate());
		}
	}
	
	public String getPlot() {
		return plot;
	}
}
