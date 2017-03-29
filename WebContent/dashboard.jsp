<!DOCTYPE html>
<html>
<head lang="en">
<title>Track my series - rate, comment, love and track your
	favorite tv shows.</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="Trackmyseries keeps track of your current tv shows. Discover new tv shows, discuss and share them with your friends." />
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body class="users users-dashboard user">
	<jsp:include page="loggedTamplate.jsp"></jsp:include>
		<div id="container">
		<div class="hp-inner">
					<div class="top clearfix">
					<h1>Welcome, <%= session.getAttribute("username") %>! Browse your episode list and show list bellow:</h1>
					<h2 class="not-active"><a href="/episode_list">Episode list</a></h2>
					<h2 class="not-active"><a href="/show_list">Show list</a></h2>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
