<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style_login.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
	type='text/css'>
<!--//webfonts-->
<script
	src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/loginCheck.js">
	
</script>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>
	<!--SIGN UP-->
	<h1 onclick="location.href='toIndex.do'" style="cursor: pointer;">Fun ChangSha</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png" />
		</div>
		<p style=" text-align:right;">
			<span onclick="location.href='toSignIn.do'"
				style="margin-right:8px; font-weight:bold; color:#666;cursor: pointer;">注册</span>
		</p>
		<form action="login.do" method="post"
			onsubmit="return check_email()+check_psw()==2;">
			<input type="text" class="text" name="email" id="email"
				onblur="check_email()" placeholder="email" value="${param.email}">
			<div class="key">
				<input type="password" name="password" id="password"
					placeholder="password" onblur="check_psw()"
					value="${param.password}">
				<p>
					<span id="info">${error }</span>
				</p>
			</div>
			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
	<br />
	<br />
	<div class="copy-rights">
		<p>Copyright &copy; 2015.Company name All rights reserved.
			From-咸鱼组</p>
	</div>

</body>
</html>