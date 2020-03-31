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
		<h1>인덱스 페이지</h1>
		
		<input type="button" value="회원목록" onclick="location.href='${contextPath}/member/membersList.do';"><br/>
		<input type="button" value="회원가입" onclick="location.href='${contextPath}/member/memberJoinForm.do';">
	</body>
</html>