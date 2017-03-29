package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CommentDAO;

@WebServlet("/add comment to show")
public class AddCommentToShowServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getSession().getAttribute("logged"));
		String comment = req.getParameter("comment");
		String username = (String) req.getSession().getAttribute("username");
	    resp.sendRedirect("loggedTamplate.jsp");
	}
	
}
