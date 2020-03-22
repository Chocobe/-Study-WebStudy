<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%= application.getContextPath() %>"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<h1>index.jsp 페이지</h1>
		<input type="button" value="로그인" onclick="location.href='${contextPath}/views/loginForm.do';">
		
		<form action="${contextPath}/views/loginForm.do" method="POST">
			<input type="submit" value="로그인 Form">
		</form>
	</body>
</html>