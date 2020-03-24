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
		<h1>회원검색</h1>
		
		<form method="POST" action="${contextPath}/mem4.do">
			<input type="hidden" name="action" value="searchMember">
			이름 : <input type="text" name="name"><br/>
			이메일 : <input type="text" name="email"><br/>
			<input type="submit" value="검색">
		</form>
	</body>
</html>