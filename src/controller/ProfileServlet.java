package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
        if(session.getAttribute("logged") != null) {
        	boolean logged = (Boolean) req.getSession().getAttribute("logged");
        	if(logged) {
        		resp.sendRedirect("profile.jsp");
        	} else {
        		resp.sendRedirect("login.jsp");
        	}
        } else {
        	resp.sendRedirect("login.jsp");
        }
	}
}
