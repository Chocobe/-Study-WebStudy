<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	MemberBean m1 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	MemberBean m2 = new MemberBean("ki", "4321", "기성용", "ki@test.com");
	MemberBean m3 = new MemberBean("park", "9876", "박지성", "park@test.com");
	
	List<MemberBean> membersList = new ArrayList<MemberBean>();
	membersList.add(m1);
	membersList.add(m2);
	membersList.add(m3);
%>

<c:set var="list" value="<%= membersList %>" scope="page"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>회원정보 출력창</title>
	</head>

	<body>
		<table border="1" align="center">
			<tr align="center" bgcolor="99CCFF">
				<td width="7%"><b>이름</b></td>
				<td width="7%"><b>비밀번호</b></td>
				<td width="5%"><b>이름</b></td>
				<td width="5%"><b>이메일</b></td>
			</tr>
			
			<c:forEach var="member" items="${list}">
				<tr align="center">
					<td>${member.id}</td>
					<td>${member.pwd}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>