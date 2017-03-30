package model;

import java.time.LocalDateTime;


public class Comment {
	private User user;
	private LocalDateTime date;
	private String content;
	
	public Comment(User user, String content, LocalDateTime date) {
		this.user = user;
		this.content = content;
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
		
	public User getUser() {
		return user;
	}
	
	
}
