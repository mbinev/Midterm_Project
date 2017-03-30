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
import model.dao.CommentDAO;
import model.dao.ShowDAO;
import model.dao.UserDAO;

@WebServlet("/add comment to show")
public class AddCommentToShowServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("logged") == null) {
			resp.sendRedirect("login.jsp");
		} else if((Boolean) session.getAttribute("logged")) {	
			try {
				String showName = req.getParameter("show");
				Show show = ShowDAO.getInstance().getAllShows().get(showName);
				System.out.println(show.getPlot());
				String comment = req.getParameter("comment");
				System.out.println(comment);
				String username = (String) session.getAttribute("username");
				User user = UserDAO.getInstance().getAllUsers().get(username);
				ShowDAO.getInstance().commentShow(comment, user, show);
				show.getComments();
				resp.sendRedirect("game_of_thrones.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
				resp.sendRedirect("error500.html");
			}
			
		} else {
			resp.sendRedirect("login.jsp");
		}
	}
	
}
