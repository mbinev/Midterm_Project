<!DOCTYPE html>
<html>
<head>
<title>Sign up an account to Track My Series</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="Track My Series keeps track of your current tv shows. Discover new tv shows, discuss and share them with your friends." />
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body class="users users-signup guest">
	<div id="mainContainer">
		<div id="head">
			<div class="inner">
				<h1 class="logo">
					<a href="index.html">Track My Series</a>
				</h1>
				<div class="navigation">
					<ul>
						<li class="inactive"><a href="index.html">Home</a></li>
						<li class="inactive"><a href="/shows/popular">Shows</a></li>
					</ul>
				</div>
				<div class="search-wrapper">
					<div class="search">
						<form action="/shows/search" id="searchform" method="get"
							accept-charset="utf-8">
							<div style="display: none;">
								<input type="hidden" name="key"
									value="e2ec8ec81cc1353a2c05a71ce2125a09adc60bee"
									id="Token275880280" />
							</div>
							<input name="showName" type="text"
								placeHolder="Search shows or users" id="searchField"
								class="text" />
						</form>
					</div>
				</div>
				<div class="service-wrapper">
					<ul class="service logged-out">
						<li><a href="/TrackMySeries/register.html">Sign up</a></li>
						<li class="last"><a href="/TrackMySeries/login.html"
							class="modalLogin">Sign in</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="container">
			<div class="hp-inner">
				<div class="top clearfix">
					<div class="left">
						<div class="msg">
							<h2>Create an account for Track My Series</h2>
							<div class="legacy">
								<form action="register" autocomplete="off" method="post"
									accept-charset="utf-8">
									<div class="input text required">
										<input name="username" type="text" required="required"
											class="minLength:3 maxLength:15 validate-alphanum validateRemote"
											tabindex="1" maxlength="255" placeholder="Username" />
									</div>
									<div class="input text required">
										<input name="email" type="text" required="required"
											class="minLength:7" tabindex="2" placeholder="Email" />
									</div>
									<div class="input password">
										<label>Digit/upper case letter/8 characters</label> <input
											type="password" name="password" required="required"
											class="minLength:8" tabindex="3" placeholder="Password" />
									</div>
									<div class="input password">
										<input type="password" name="confirm password"
											required="required" class="minLength:5" tabindex="3"
											placeholder="Confirm password" />
									</div>
									<div class="input text">
										<label>Country:</label> <select name="country">
											<option value="Bulgaria">Bulgaria</option>
											<option value="Romania">Romania</option>
											<option value="Greece">Greece</option>
											<option value="Other">Not Listed</option>
										</select>
									</div> 

									<div class="input text required">
										<input type="number" name="age" required="required"
											class="minLength:1" tabindex="5" placeholder="Age" />
									</div>
									<div class="input signup">
										<input class="f-button" tabindex="8" type="submit"
											value="Create account" />
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
