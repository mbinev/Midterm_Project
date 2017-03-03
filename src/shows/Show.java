package shows;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeMap;
import users.User;
public class Show {
	
	public class Season{
		
		public class Episode{
			int number;
			private String plot;
			private LocalDate airingDate;
			private boolean isWached;
			
			private Episode(int number){
				this.number = number;
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
	
	public String getName() {
		return name;
	}
	
}

