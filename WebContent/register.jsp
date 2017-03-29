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
	<jsp:include page="notLoggedTamplate.jsp"></jsp:include>
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
