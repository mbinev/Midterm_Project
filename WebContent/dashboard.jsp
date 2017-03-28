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
	<div id="mainContainer">
		<div id="head">
			<div class="inner">
				<h1 class="logo">
					<a href="dashboard.html">Dashboard</a>
				</h1>
				<div class="navigation">
					<ul>
						<li class="active"><a href="dashboard.html">Home</a></li>
						<li class="inactive"><a href="/shows/popular">Shows</a></li>
						<li class="inactive"><a href="profile.html">Profile</a></li>
					</ul>
				</div>
				<div class="search-wrapper">
					<div class="search">
						<form action="/shows/search" id="searchform" method="get"
							accept-charset="utf-8">
							<div style="display: none;">
								<input type="hidden" name="key"
									value="843d5f985cf110e85bb100768b72c06bc9f9a5fe"
									id="Token1951393496" />
							</div>
							<input name="showName" type="text"
								placeHolder="Search shows or users" id="searchField"
								class="text" />
						</form>
					</div>
				</div>
				<div class="service-wrapper">
					<ul class="service logged-in">
						<li class="menu">
							<div class="extra">
								<h2 class="signout">
									<a href="logout">Sign out</a>
								</h2>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="container">
		<div class="hp-inner">
					<div class="top clearfix">
					<h1>Welcome, ${userName}! Browse your episode list and show list bellow:</h1>
					<h2 class="not-active"><a href="/episode_list">Episode list</a></h2>
					<h2 class="not-active"><a href="/show_list">Show list</a></h2>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
