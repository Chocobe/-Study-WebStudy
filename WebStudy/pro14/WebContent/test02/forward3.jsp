<%@page import="java.util.ArrayList"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%
	request.setCharacterEncoding("UTF-8");

	List<MemberBean> membersList = new ArrayList<MemberBean>();
	
	MemberBean m1 = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	MemberBean m2 = new MemberBean("son", "4321", "손흥민", "son@test.com");
	
	membersList.add(m1);
	membersList.add(m2);
	
	request.setAttribute("membersList", membersList);
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>forward3</title>
	</head>

	<body>
		<jsp:forward page="member3.jsp"/>
	</body>
</html>