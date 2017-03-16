package shows;

import java.time.LocalDate;
import users.User;


public class Comment {
	private User user;
	private LocalDate date;
	private String content;
	
	public Comment(User user, String content) {
		this.user = user;
		this.content = content;
		this.date = LocalDate.now();
	}
	
	public String getContent() {
		return content;
	}
	
	public LocalDate getDate() {
		return date;
	}
		
	public User getUser() {
		return user;
	}
}
