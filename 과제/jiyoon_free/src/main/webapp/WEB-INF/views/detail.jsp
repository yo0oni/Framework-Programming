<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>일정 세부 정보</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css3.css">
</head>

<body>

	<h2>Schedule Detail</h2>

	<table border="1">

		<tr>

			<th style="text-align: center">날짜</th>

			<td>${schedule.date}</td>

		</tr>

		<tr>

			<th style="text-align: center">일정</th>

			<td><c:forEach var="detail" items="${schedule.detailList}">
					<ul>
						<li>${detail}</li>
					</ul>

				</c:forEach></td>

		</tr>

	</table>
	<div class="button">
		<button
			onclick="location.href='${pageContext.request.contextPath}/schedules/list'">모든
			일정 보기</button>

		<c:if test="${userId eq schedule.userId}">

			<button
				onclick="location.href='${pageContext.request.contextPath}/schedules/edit/${schedule.id}'">수정</button>
			<form
				action="${pageContext.request.contextPath}/schedules/delete/${schedule.id}"
				method="post" style="display: inline;">

				<button type="submit">삭제</button>

			</form>

		</c:if>
	</div>

</body>

</html>