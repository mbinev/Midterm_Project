<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome - Track My Series</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="Track My Series keeps track of your current tv shows. Discover new tv shows, discuss and share them with your friends." />
<meta http-equiv="content-language" content="en" />
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body class="users users-login guest">
	<jsp:include page="notLoggedTamplate.jsp"></jsp:include>
	<div id="container">
		<div class="hp-inner">
			<div class="top clearfix">
				<div class="left">
					<div class="content-body">
						<div class="login-form-wrapper clearfix">
							<h2 style="color:red">Incorrect username/password, please try again</h2>
							<div class="legacy">
								<form action="login" method="post" accept-charset="utf-8">
									<div style="display: none;">
										<input type="hidden" name="_method" value="POST" /><input
											type="hidden" name="data[_Token][key]"
											value="e2ec8ec81cc1353a2c05a71ce2125a09adc60bee"
											id="Token580535520" />
									</div>
									<div class="input text required">
										<label>Your username</label> <input name="username"
											type="text" required="required" tabindex="1" maxlength="255" />
									</div>
									<div class="input password">
										<div class="passwordlabel">
											<label for="UserPassword">Your password</label>
										</div>
										<input type="password" name="password" required="required"
											tabindex="2" />
									</div>
									<div class="input submit login clearfix">
										<input class="f-button" tabindex="103" type="submit"
											value="Sign in" /> or <a href="/TrackMySeries/register.jsp">sign
											up now!</a>
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
