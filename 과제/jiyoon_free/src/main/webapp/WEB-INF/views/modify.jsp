<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>

<html>
<head>
<title>일정 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css4.css">

</head>


<body>

	<form name="form1"
		action="${pageContext.request.contextPath}/schedules/edit/${schedule.id}"
		method="post">
		           
		<div style="text-align: center; margin-right: 40px; margin-top: 70px">
			<input style="border: noe;" type="text" class="input"
				name="date" value="${schedule.date}" /></div>
		<div class="div">
			<c:forEach items="${schedule.detailList}" var="detailItem"
				varStatus="status">

				<div>
					<ol>
						<li><span>${status.index + 1}</span>
							<p>
								<input style="border: noe;" type="text" class="input"
									name="detailList" value="${detailItem}" />
							<p></li>
					</ol>
				</div>
                </c:forEach>
			<br>
			<div style="text-align: center; margin-top: 20px;">
				<input type="hidden" name="userId" value="${schedule.userId}">
				<input
					style="font-size: 20px; padding: 15px 15px; background-color: #ccc; border: none; border-radius: 20px;"
					type="submit" name="submit" value="수정 완료"> <input
					style="font-size: 20px; padding: 15px 15px; background-color: #ccc; border: none; border-radius: 20px;"
					type="reset" name="reset" value="다시 작성">      
			</div>
			 

		</div>
	</form>

</body>

</html>
