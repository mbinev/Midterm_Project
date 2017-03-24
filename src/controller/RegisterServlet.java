package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.dao.DBManager;
import model.dao.UserDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO add the new user to DB
		
		//get parameters
		String userName = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String country = req.getParameter("country");
		String age = req.getParameter("age");
		
		//validate parameters
		boolean validUserName = validateUserName(userName);
		boolean validEmail = validateEmail(email);
		boolean validPassword = validatePassword(password);
		boolean validCountry = validateCountry(country);
		boolean validAge = validateAge(Integer.valueOf(age));
		//if the data is not valid //if the data is valid
		String fileName = "index.html";
		if(validUserName && validEmail && validPassword && validCountry && validAge) {
			User u = new User(userName,Integer.valueOf(age), country, email, password);
			try {
				UserDAO.getInstance().addUser(u);
			} catch (SQLException e) {
				fileName = "registerFail.html";
			}
			RequestDispatcher rd1 = req.getRequestDispatcher(fileName);
			rd1.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("registerFail.html");
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
