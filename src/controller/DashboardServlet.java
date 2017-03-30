package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Show;
import model.User;
import model.dao.UserDAO;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("logged") != null) {
        	boolean logged = (Boolean) req.getSession().getAttribute("logged");
        	if(logged) {
        		String username = (String) session.getAttribute("username");
				HashMap<String, User> users;
				try {
					users = UserDAO.getInstance().getAllUsers();
					TreeMap<String, Show> following = UserDAO.getInstance().getFollowingShows( users.get(username));
					req.setAttribute("following", following);
	        		resp.sendRedirect("dashboard.jsp");
				} catch (SQLException e) {
					//TODO
				}
				
        	} else {
        		resp.sendRedirect("login.jsp");
        	}
        } else {
        	resp.sendRedirect("login.jsp");
        }
		
//		HttpSession session = req.getSession(true);
//		String userName = (String)session.getAttribute("userName");
//		req.setAttribute("userName", userName);
//		req.getRequestDispatcher("dashboard.jsp").include(req, resp);
	}

}
