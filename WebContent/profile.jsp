
<!DOCTYPE html>
<%@page import="model.User"%>
<%@page import="model.dao.UserDAO"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head lang="en" lang="en">
<title>Track my series - rate, comment, love and track your
	favorite tv shows.</title>
<meta http-equiv="content-language" content="en" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="Trackmyseries keeps track of your current tv shows. Discover new tv shows, discuss and share them with your friends." />
<meta http-equiv="content-language" content="en" />
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body class="users users-view user">
	<jsp:include page="loggedTamplate.jsp"></jsp:include>
<table>
   <div id="container">
		<div id="container" class="hp-inner">
			<div class="top clearfix">
				<h1>
					<%=session.getAttribute("profile")%>`s Profile
				</h1>
				<%	String username = (String) session.getAttribute("profile");
					User u = UserDAO.getInstance().getAllUsers().get(username);%>
				<h2>
					Email: <%=u.getEmail()%>
				</h2>
				<h2>
					Country: <%=u.getCountry()%>
				</h2>
				<h2>
					Age: <%=u.getAge()%>
				</h2>
				<jsp:include page="friends.jsp"></jsp:include>
			</div>
		</div>
	</div>
</table>
</body>
</html>
