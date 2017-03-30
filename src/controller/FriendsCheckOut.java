package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.dao.UserDAO;

@WebServlet("/friends")
public class FriendsCheckOut extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ss");
		HttpSession session = req.getSession();
        if(session.getAttribute("logged") != null) {
        	boolean logged = (Boolean) req.getSession().getAttribute("logged");
        	if(!logged) {	
        		resp.sendRedirect("login.jsp");
        	}      
        } else {
        	resp.sendRedirect("login.jsp");
        }
        String username = (String) session.getAttribute("username");
        try {
        	User sender = UserDAO.getInstance().getAllUsers().get(username);
			User reciever = UserDAO.getInstance().getAllUsers().get(req.getParameter("request"));
			UserDAO.getInstance().sendFriendRequest(sender, reciever);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
		dispatcher.forward(req, resp);
	}

}
