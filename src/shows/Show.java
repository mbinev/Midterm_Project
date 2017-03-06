package shows;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeMap;
import users.User;
import shows.Comment;
public class Show {
	
	public class Season{
		
		public class Episode{
			private int number;
			private String name;
			private String plot;
			private LocalDate airingDate;
			private boolean isWached;
			private LinkedList<Comment> comments;
			
			private Episode(int number){
				this.number = number;
				this.isWached = false;
				comments = new LinkedList<Comment>();
			}
			
			public boolean getIsWached() {
				return this.isWached;
			}
			
			public void setIsWached() {
				this.isWached = true;
			}
			
			public void addComment(User user, String content) {
				this.coments.add(new Comment(user, content));
			}
			
		}
		
		int number;
		TreeMap<Integer ,Episode> episodes;
		public Season(int number) {
			this.number = number;
			episodes = new TreeMap<Integer, Episode>();
		}
		
		public void addEpisode(int number){
			if(!this.episodes.containsKey(number)){
				this.episodes.put(number, new Episode(number));
			}else{
				System.out.println("There is already an episode " + number + " in this season!");
			}			
		}
	}
	
	private String name;
	private String plot;
	private int voteCount;
	private HashSet<User> voters;
	private HashSet<User> followers;
	TreeMap<Integer, Season> seasons;
	private LinkedList<Comment> comments;
	
	public Show(String name) {
		this.name = name;
		seasons = new TreeMap<Integer, Season>();
		voters = new HashSet<User>();
		followers = new HashSet<User>();
		comments = new LinkedList<Comment>();
	}
	
	public void addSeason(int number){
		if(!seasons.containsKey(number)){
			this.seasons.put(number, new Season(number));
		}else{
			System.out.println("This show has already a season " + number);
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
	
	public TreeMap<Integer, Season> getSeasons() {
		return seasons;
	}
	
	public String getName() {
		return name;
	}
	
	public void addComment(User user, String content) {
		this.coments.add(new Comment(user, content));
	}
}

