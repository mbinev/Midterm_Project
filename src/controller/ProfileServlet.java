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
        if(req.getParameter("request") == null){        	
        	System.out.println("?");
        	session.setAttribute("profile", session.getAttribute("username"));
        }else{
        	System.out.println("fasfsa");
        	String username = (String) session.getAttribute("username");
            try {
            	User sender = UserDAO.getInstance().getAllUsers().get(username);
    			User reciever = UserDAO.getInstance().getAllUsers().get(req.getParameter("request"));
    			System.out.println(sender);
    			System.out.println(reciever);
    			UserDAO.getInstance().sendFriendRequest(sender, reciever);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("agagwaga");
		HttpSession session = req.getSession();
		if(session.getAttribute("logged") != null) {
        	boolean logged = (Boolean) req.getSession().getAttribute("logged");
        	if(!logged) {	
        		resp.sendRedirect("login.jsp");
        	}      
        } else {
        	resp.sendRedirect("login.jsp");
        }
		System.out.println("wtf");
		if(req.getParameter("request") != null){
			System.out.println("fsafas");
			String username = (String) session.getAttribute("username");
            try {
            	User sender = UserDAO.getInstance().getAllUsers().get(username);
    			User reciever = UserDAO.getInstance().getAllUsers().get(req.getParameter("request"));
    			System.out.println(sender);
    			System.out.println(reciever);
    			UserDAO.getInstance().sendFriendRequest(sender, reciever);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		}
		if(req.getParameter("delete") != null){
			String username = (String) session.getAttribute("username");
			String delete = req.getParameter("delete");
			User u;
			User f;
			try {
				u = UserDAO.getInstance().getAllUsers().get(username);
				f = UserDAO.getInstance().getAllUsers().get(delete);
				UserDAO.getInstance().removeFriends(u, f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ops");
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
			dispatcher.forward(req, resp);
		}	
			session.setAttribute("profile", req.getParameter("profile"));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
			dispatcher.forward(req, resp);
	}
}
