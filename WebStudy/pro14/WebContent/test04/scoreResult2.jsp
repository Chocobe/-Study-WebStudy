<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<c:set var="score" value="${param.score}"/>
		
		<h1>
			시험점수
			<c:out value="${score}"/>
		</h1>
		
		<br/><br/>
		
		<c:choose>
			<c:when test="${score >= 0 && score <= 100}">
				<c:choose>
					<c:when test="${score >= 90 && score <= 100}">
						<h1>A학점 입니다. (점수 : ${score})</h1>
					</c:when>
					
					<c:when test="${score >= 80 && score < 90}">
						<h1>B학점 입니다. (점수 : ${score})</h1>
					</c:when>
					
					<c:when test="${score >= 70 && score < 80}">
						<h1>C학점 입니다. (점수 : ${score})</h1>
					</c:when>
					
					<c:when test="${score >= 60 && score < 70}">
						<h1>D학점 입니다. (점수 : ${score})</h1>
					</c:when>
					
					<c:otherwise>
						<h1>F학점 입니다. (점수 : ${score})</h1>
					</c:otherwise>
				</c:choose>
			</c:when>
			
			<c:otherwise>
				<h1>점수를 잘 못 입력하였습니다. 다시 입력해 주세요</h1>
				<a href="./scoreTest.jsp">점수입력 창으로 이동</a>
			</c:otherwise>
		</c:choose>
	</body>
</html>