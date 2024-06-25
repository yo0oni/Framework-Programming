<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>일정 목록</title>
<link rel="stylesheet" href="../resources/css2.css">
</head>

<body>

	<h1>Schedule List</h1>

	<table border="1">

		<thead>

			<tr>
				<th style="text-align: center">만든이</th>
				<th style="text-align: center">날짜</th>
				<th style="text-align: center">수정 및 삭제</th>

			</tr>

		</thead>

		<tbody>

			<c:forEach var="schedule" items="${schedules}">

				<tr>
					<td>${schedule.userId}</td>
					<td><a
						href="${pageContext.request.contextPath}/schedules/detail/${schedule.id}">${schedule.date}</a></td>

					<c:if test="${userId eq schedule.userId}">

						<td><button
								onclick="location.href='${pageContext.request.contextPath}/schedules/edit/${schedule.id}'">수정</button>


							<form
								action="${pageContext.request.contextPath}/schedules/delete/${schedule.id}"
								method="post" style="display: inline;">

								<button type="submit">삭제</button>

							</form></td>
					</c:if>
				</tr>

			</c:forEach>

		</tbody>

	</table>
	<form action="/schedules/home" method="get">
		<button class="create" type="submit">새로운 일정 만들기</button>
	</form>

</body>

</html>