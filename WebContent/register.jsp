<!DOCTYPE html>
<html>
<head>
<title>Sign up an account to Track My Series</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="Track My Series keeps track of your current tv shows. Discover new tv shows, discuss and share them with your friends." />
<meta http-equiv="content-language" content="en" />
<link rel="stylesheet" type="text/css" href="styles.css" />
<script type="text/javascript" src="jsstyles.js"></script>
</head>
<body class="users users-signup guest">
	<div id="mainContainer">
		<div id="head">
			<div class="inner">
				<h1 class="logo"><a href="index.html">Track My Series</a></h1>
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
							<div style="display: none;">
								<input type="hidden" name="fields"
									value="5c16f520d0a386c7b09b8ee76f784f787bb566c9%3A"
									id="TokenFields1329920994" />
							</div>
						</form>
					</div>
				</div>
				<div class="service-wrapper">
					<ul class="service logged-out">
						<li><a href="/TrackMySeries/register.html">Sign up</a></li>
						<li class="last"><a href="/TrackMySeries/login.html" class="modalLogin">Sign
								in</a></li>
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
								<form action="register" autocomplete="off"
									method="post" accept-charset="utf-8">
									<div style="display: none;">
										<input type="hidden" name="_method" value="POST" /><input
											type="hidden" name="data[_Token][key]"
											value="e2ec8ec81cc1353a2c05a71ce2125a09adc60bee"
											id="Token1031000789" />
									</div>
									<div class="input text required">
										<label for="UserUsername">Username</label><input
											name="username" type="username" required="required"
											class="minLength:3 maxLength:15 validate-alphanum validateRemote"
											tabindex="1" maxlength="255" />
									</div>
									<div class="input text required">
										<label for="UserEmail">Email</label><input
											name="email" type="text" required="required"
											class="minLength:7" tabindex="2"/>
									</div>
									<div class="input password">
										<label for="UserPasswordFirst">Password (digit/upper
										case letter/8 characters)</label><input
											type="password" name="password" required="required"
											class="minLength:5" tabindex="3" />
									</div>
									<div class="input text required">
										<label for="UserCountry">Country</label><input
											type="country" name="country" required="required"
											class="minLength:5" tabindex="4" />
									</div>
									<div class="input text required">
										<label for="UserAge">Age</label><input
											type="age" name="age" required="required"
											class="minLength:1" tabindex="5" />
									</div>
									<div class="input signup">
										<input class="f-button" tabindex="8" type="submit" value="Create account" />
									</div>
									<div style="display: none;">
										<input type="hidden" name="data[_Token][fields]"
											value="601e7ad268c6c51f648e98b1be2425f51073c49a%3A"
											id="TokenFields1419894355" />
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