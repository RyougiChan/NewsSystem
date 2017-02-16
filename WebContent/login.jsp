<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/login.css" />
</head>

<body>
	<div id="main_container">
		<!-- Banner S -->
		<div id="banner">
			<div id="banner_logo"></div>
		</div>
		<!-- Banner E -->
		<!-- Main Container S -->
		<div id="main">
			<div id="loginPane">
				<div id="loginNotice">
					<div>
						<h2>Notice</h2>
						<br>
						<div>
							1 If you don't have a account to access. Please ask <a href="">adminstrator</a>
							for help.
						</div>
						<br>
						<div>2 If you have your account but forget your password.
							Click link below to recover your password.</div>
						<br> <a href="">>>>Recover your password<<<</a>
					</div>
				</div>
				<div id="loginForm">
					<form action="adminLogin" method="post">
						<h1>内容管理系统</h1><br>
						<h2>Content Manage System</h2><br>
						<p>User</p>
						<div>
							<input id="loginName" name="loginName" type="text" />
						</div>
						<p>Password</p>
						<div>
							<input id="loginPwd" name="loginPwd" type="password" />
						</div>
						<div>
							<input type="submit" name="submit" id="submit" />
						</div>
						<div>
							<input id="save" type="checkbox" /> 保存密码
						</div>
					</form>
				</div>
			</div>

		</div>
		<!-- Main Container E -->
		<!-- Footer S -->
		<div id="footer"></div>
		<!-- Footer E -->
	</div>
	<script src="js/jquery-3.1.0.js"></script>
	<script>
		$("#main").css("height", window.innerHeight - 300);
		$(window).resize(function() {
			$("#main").css("height", window.innerHeight - 300);
		});
	</script>
</body>

</html>