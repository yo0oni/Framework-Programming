<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성된 일정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css3.css">
</head>
<body>
	<h1>Schedule</h1>
	<c:if test="${not empty schedule}">
		<ul>
			<li><strong>날짜:</strong> ${schedule.date}<br><br>
				<ul>
					<c:forEach items="${schedule.detailList}" var="detail">
						<li>${detail}</li>
					</c:forEach>
				</ul></li>
		</ul>
	</c:if>
	<c:if test="${empty schedule}">
		<p>No schedule available.</p>
	</c:if>
	<form action="/schedules/list" method="get">
		<button type="submit">모든 일정 보기</button>
	</form>
</body>
</html>