package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie cookie[] = req.getCookies();
		if (cookie != null) {
			RequestDispatcher rd = req.getRequestDispatcher("dashboard.html");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
	}
}
