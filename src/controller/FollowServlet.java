package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Show;
import model.User;
import model.dao.ShowDAO;
import model.dao.UserDAO;

@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("logged") == null) {
			response.sendRedirect("login.jsp");
		} else if((Boolean) session.getAttribute("logged")) {
			String showName = request.getParameter("show");
			String username = (String) session.getAttribute("username");
			try {
				User user = UserDAO.getInstance().getAllUsers().get(username);
				Show show = ShowDAO.getInstance().getAllShows().get(showName);
				UserDAO.getInstance().addToMyFollowing(user, show);
				System.out.println(user.getMyFollowing());
				response.sendRedirect("game_of_thrones.jsp");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				response.sendRedirect("error500.html");
			}	
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
