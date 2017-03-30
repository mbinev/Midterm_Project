<%@page import="java.util.Map.Entry"%>
<%@page import="model.User"%>
<%@page import="model.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  String username =(String) session.getAttribute("profile");
		String name = (String) session.getAttribute("username");
		User user = UserDAO.getInstance().getAllUsers().get(name);
		if(!name.equals(username) && !user.getFriends().containsKey((String) session.getAttribute("profile"))) {%>
		<form action="profile" method="post">
			<button name="request" value= "<%=username%>"> Sent friend request</button>
		</form>
		<%} %>
	<h2>Friends :</h2>
	<%
		User u = UserDAO.getInstance().getAllUsers().get(username);
		UserDAO.getInstance().getAllFriends(u);
		for(Entry<String, User> entry : u.getFriends().entrySet()){%>
			
			<form action="profile" method="post">
				<button name="profile" value= "<%=entry.getValue().getUserName()%>"> View <%= entry.getValue().getUserName() %> Profile!</button>
			</form>
			<%if(session.getAttribute("username") == session.getAttribute("profile")){ %>
				<form action="profile" method="post">
					<button name="delete" value= "<%=entry.getValue().getUserName()%>"> Remove from friends!</button>
				</form>
			<%} %>
			<br>
	<%	} %>
	<%if(session.getAttribute("username") == session.getAttribute("profile")){ %>
		<form action="profile" method="post">
			<button name="something" value= "<%=username%>"> Remove from friends!</button>
		</form>
	<%} %>
</body>
</html>