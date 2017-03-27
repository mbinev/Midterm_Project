
package model;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Show.Season.Episode;

public class User {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	// at least one digit,at least one upper case letter, at least 8 characters, no whitespaces

	private long userId;
	private String userName;
	private int age;
	private String country;
	private String email;
	private String password;
	private TreeMap<String, Show> myFollowing; // showName - > show
	private HashMap<String, User> friends; // username -> user
	
	public User(String userName, int age, String country, String email, String password) {
		this.setUserName(userName);
		this.setAge(age);
		this.setCountry(country);
		this.setEmail(email);
		this.setPassword(password);
		this.myFollowing = new TreeMap<String, Show>();
		this.friends = new HashMap<>();
	}
	
	public void addShow(Show show) {
		if(!myFollowing.containsKey(show.getShowName())) {
			myFollowing.put(show.getShowName(), show);
			System.out.println("Successfully added show " + show.getShowName() + " to your list.");
			return;
		}
		System.out.println("Show " + show.getShowName() + " was already in your list.");
	}
	
	public void removeShow(Show show) {
		if(myFollowing.containsKey(show.getShowName())) {
			myFollowing.remove(show.getShowName());
			System.out.println("Successfully removed show " + show.getShowName() + " from your list.");
			return;
		}
		System.out.println("Show " + show.getShowName() + " was never on your list.");
	}
	
	public void rateShow(Show show, int rating) {
		show.vote(this, rating);
	}
	
	public void rateEpisode(Show show, int season, int episode, int raiting) {
		Episode e = show.getSeasons().get(season).getEpisode().get(episode);
		e.vote(this, raiting);
	}
	
	public void checkEpisodeAsWatched(Episode e) {
		if(e.getIsWached()) {
			System.out.println("The episode is already checked as watched.");
		} else {
			 e.setIsWached();
		}		
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public HashMap<String, User> getFriends() {
		return friends;
	}
	
	public String getUserName() {
		return userName;
	}
	
	private void setUserName(String userName) {
		if(isNullOrEmpty(userName)) {
			this.userName = "JhonDoe";
			return;
		}
		this.userName = userName;
	}
	
	public int getAge() {
		return age;
	}
	
	private void setAge(int age) {
		if(age < 0 || age > 100) {
			this.age = 18;
			return;
		}
		this.age = age;
	}
	
	public String getCountry() {
		return country;
	}
	
	private void setCountry(String country) {
		if(isNullOrEmpty(country)) {
			this.country = "Unknown";
			return;
		}
		this.country = country;
	}
	
	public TreeMap<String, Show> getMyFollowing() {
		return myFollowing;
	}
	
	public String getEmail() {
		return email;
	}
	
	private void setEmail(String email) {
		if(validateEmail(email)) {
			this.email = email;
		}
		
	}
	
	public String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	private boolean validateEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}

	private boolean isNullOrEmpty(String text) {
		return text.isEmpty() || text == null;
	}
	
	public void makeComment(Show show, String content){
		show.addComment(this, content);
	}
	public void makeComment(Episode episode, String content){
		episode.addComment(this, content);
	}

}
