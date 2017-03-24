package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO add the new user to DB
		
		//get parameters
		String userName = req.getParameter("username");
		System.out.println(userName);
		String email = req.getParameter("email");
		System.out.println(email);
		String password = req.getParameter("password");
		System.out.println(password);
		String country = req.getParameter("country");
		System.out.println(country);
		String age = req.getParameter("age");
		System.out.println(age);
		
		//validate parameters
		boolean validUserName = validateUserName(userName);
		boolean validEmail = validateEmail(email);
		boolean validPassword = validatePassword(password);
		boolean validCountry = validateCountry(country);
		boolean validAge = validateAge(Integer.valueOf(age));
		//if the data is not valid //if the data is valid
		if(validUserName && validEmail && validPassword && validCountry && validAge) {
			RequestDispatcher rd1 = req.getRequestDispatcher("index.html");
			rd1.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.forward(req, resp);
		}		
	}
	
	private boolean validateUserName(String userName) {
		if(isNullOrEmpty(userName)) {
			return false;
		}
		return true;
	}
	
	private boolean validateEmail(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
	
	private boolean validatePassword(String password) {
		Pattern VALID_PASSWORD_REGEX = Pattern.compile("(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}");
	    // at least one digit,at least one upper case letter, at least 8 characters, no whitespaces
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
		return matcher.find();
	}
	
	private boolean validateCountry(String country) {
		if(isNullOrEmpty(country)) {
			return false;
		}
		return true;
	}
	
	private boolean validateAge(int age) {
		if(age > 0 && age < 120) {
			return true;
		}
		return false;
	}
	
	private boolean isNullOrEmpty(String text) {
		return text.isEmpty() || text == null;
	}
}
