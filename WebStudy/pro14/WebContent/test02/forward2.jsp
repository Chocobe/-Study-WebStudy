<%@page import="sec01.ex01.MemberBean"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%
	request.setCharacterEncoding("UTF-8");
	MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	
	request.setAttribute("member", member);
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>forward2</title>
	</head>

	<body>
		<jsp:forward page="member2.jsp"/>
	</body>
</html>