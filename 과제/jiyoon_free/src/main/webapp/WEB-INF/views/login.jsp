<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="../resources/css.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".user").focusin(function() {
			$(".inputUserIcon").css("color", "#e74c3c");
		}).focusout(function() {
			$(".inputUserIcon").css("color", "white");
		});

		$(".pass").focusin(function() {
			$(".inputPassIcon").css("color", "#e74c3c");
		}).focusout(function() {
			$(".inputPassIcon").css("color", "white");
		});
	});
</script>
</head>
<body>
	<div class="container">
		<form action="/users/login" method="post">
			<h2>
				<span class="entypo-login"><i class="fa fa-sign-in"></i></span>
				Login
			</h2>
			<button class="submit">
				<span class="entypo-lock"><i class="fa fa-lock">🔓</i></span>
			</button>
			<span class="entypo-user inputUserIcon"> <i class="fa fa-user"></i>
			</span> <input type="text" class="user" name="id" placeholder="id" />
			<span class="entypo-key inputPassIcon"> <i class="fa fa-key"></i>
			</span> <input type="password" name="password" class="pass"
				placeholder="password" />
		</form>
	</div>
</body>
</html>