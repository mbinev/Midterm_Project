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
<body>
	<div id="mainContainer">
		<div id="head">
			<div class="inner">
				<h1 class="logo">
					<a href="index.jsp">Track My Series</a>
				</h1>
				<div class="navigation">
					<ul>
						<li class="active"><a href="index.jsp">Home</a></li>
						<li class="inactive"><a href="shows.jsp">Shows</a></li>
					</ul>
				</div>
				<div class="search-wrapper">
					<div class="search">
						<form action="/shows/search" id="searchform" method="get"
							accept-charset="utf-8">
							<input name="showName" type="text"
								placeHolder="Search shows or users" id="searchField"
								class="text" />
						</form>
					</div>
				</div>
				<div class="service-wrapper">
					<ul class="service logged-out">
						<li><a href="/TrackMySeries/register.jsp">Sign up</a></li>
						<li class="last"><a href="/TrackMySeries/login.jsp"
							class="modalLogin">Sign in</a></li>
					</ul>
				</div>
			</div>
		</div>