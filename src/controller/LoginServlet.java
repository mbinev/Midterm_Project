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
import javax.servlet.http.HttpSession;

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
		HttpSession session = null;
		String error = "";
		try {
			validLogin = UserDAO.getInstance().validLogin(userName, password);
		} catch (SQLException e) {
			System.out.println("Error at validating login - " + e.getMessage());
		}
		if(validLogin) {
			session = req.getSession();
			session.setAttribute("username", userName);
			session.setAttribute("logged", true);
			session.setMaxInactiveInterval(15*60); // 15 minutes
			resp.sendRedirect("dashboard.jsp");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("loginFailed.jsp");
			rd.forward(req, resp);
		}
	}
}
