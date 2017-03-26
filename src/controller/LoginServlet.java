package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO try to validate login, if success - display main page, if fail - display error page
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		boolean validLogin = false;
		try {
			validLogin = UserDAO.getInstance().validLogin(userName, password);
		} catch (SQLException e) {
			System.out.println("Error at validating login - " + e.getMessage());
		}
		if(validLogin) {
			Cookie loginCookie = new Cookie("username", userName);
			loginCookie.setMaxAge(30*60);
			resp.addCookie(loginCookie);
			resp.sendRedirect("dashboard.html");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
	}
}
