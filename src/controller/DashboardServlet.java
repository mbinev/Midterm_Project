package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        		resp.sendRedirect("dashboard.jsp");
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
