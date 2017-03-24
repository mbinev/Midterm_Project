
package model;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Show.Season.Episode;

public class User {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_PASSWORD_REGEX = 
			Pattern.compile("(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}");
	// at least one digit,at least one upper case letter, at least 8 characters, no whitespaces

	private int userId;
	private String userName;
	private int age;
	private String country;
	private String email;
	private String password;
	private TreeMap<String, Show> myFollowing;
	
	public User(String userName, int age, String country, String email, String password) {
		this.setName(userName);
		this.setAge(age);
		this.setCountry(country);
		this.setEmail(email);
		this.setPassword(password);
		this.myFollowing = new TreeMap<String, Show>();
	}
	
	public void addShow(Show show) {
		if(!myFollowing.containsKey(show.getName())) {
			myFollowing.put(show.getName(), show);
			System.out.println("Successfully added show " + show.getName() + " to your list.");
			return;
		}
		System.out.println("Show " + show.getName() + " was already in your list.");
	}
	
	public void removeShow(Show show) {
		if(myFollowing.containsKey(show.getName())) {
			myFollowing.remove(show.getName());
			System.out.println("Successfully removed show " + show.getName() + " from your list.");
			return;
		}
		System.out.println("Show " + show.getName() + " was never on your list.");
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
	
	private void setName(String userName) {
		if(isNullOrEmpty(userName)) {
			this.userName = "JhonDoe";
			return;
		}
		this.userName = userName;
	}
	
	private void setAge(int age) {
		if(age < 0 || age > 100) {
			this.age = 18;
			return;
		}
		this.age = age;
	}
	
	private void setCountry(String country) {
		if(isNullOrEmpty(country)) {
			this.country = "Unknown";
			return;
		}
		this.country = country;
	}
	
	private void setEmail(String email) {
		if(!validateEmail(email)) {
			this.email = "johnDoe@abv.bg";
			return;
		}
		this.email = email;
	}
	
	private void setPassword(String password) {
		if(!validatePassword(password)) {
			System.out.println("Invalid password, valid one will be assigned and send to your email.");
			this.password = "12345678";
			return;
		}
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	private boolean validateEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
	
	private boolean validatePassword(String password) {
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
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
