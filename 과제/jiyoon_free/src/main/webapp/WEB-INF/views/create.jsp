<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 생성</title>
<link rel="stylesheet" href="../resources/css.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<form action="http://localhost:8080/schedules/create" method="post">
			<h2>
				<span class="entypo-login"><i class="fa fa-sign-in"></i></span>
				일정 정보 입력
			</h2>
			<button style="height: 195px" class="submit create-button">
				<span class="entypo-lock"><i class="fa fa-lock">✏️</i></span>
			</button>
			<span class="entypo-user inputUserIcon"> </span> <input type="text"
				class="user" name="destination" placeholder="여행지" /> <span
				class="entypo-key inputPassIcon"> </span> <input type="text"
				name="departureDate" class="pass" placeholder="출국 날짜" /> <span
				class="entypo-key inputPassIcon"> </span> <input type="text"
				name="returnDate" class="pass" placeholder="입국 날짜" />
		</form>
	</div>
</body>
</html>