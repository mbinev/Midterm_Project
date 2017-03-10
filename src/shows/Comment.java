import java.time.LocalDate;
import java.users.User;

public class Comment {
	private User user;
	private LocalDate date;
	private String content;
	
	public Comment(User user, String content) {
		this.user = user;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
}
