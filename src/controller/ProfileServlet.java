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

import model.User;
import model.dao.UserDAO;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
        if(session.getAttribute("logged") != null) {
        	boolean logged = (Boolean) req.getSession().getAttribute("logged");
        	if(!logged) {	
        		resp.sendRedirect("login.jsp");
        	}      
        } else {
        	resp.sendRedirect("login.jsp");
        }
        if(session.getAttribute("profile") == null){
        	session.setAttribute("profile", session.getAttribute("username"));
        }else{
        	
        }
        User u;
		try {
			u = UserDAO.getInstance().getAllUsers().get(session.getAttribute("username"));
			req.setAttribute("friends", UserDAO.getInstance().getAllFriends(u));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
            dispatcher.forward(req, resp);
		} catch (SQLException e) {
			System.out.println("ops");
			e.printStackTrace();
		}
	}
}
