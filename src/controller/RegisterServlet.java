package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO add the new user to DB
		String userName = req.getParameter("username");
		String email = req.getParameter("password");
		String password = req.getParameter("password");
		//validate data
		//if the data is not valid
		RequestDispatcher rd = req.getRequestDispatcher("register.html");
		rd.forward(req, resp);
		//if valid data
		RequestDispatcher rd1 = req.getRequestDispatcher("index.html");
		rd.forward(req, resp);
	}
}
