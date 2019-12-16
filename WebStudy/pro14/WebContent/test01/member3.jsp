<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="member" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="member" property="*"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>회원정보 출력창</title>
	</head>

	<body>
		<table align="center" border="1">
			<tr align="center" bgcolor="#99CCFF">
				<td width="20%"><b>아이디</b></td>
				<td width="20%"><b>비밀번호</b></td>
				<td width="20%"><b>이름</b></td>
				<td width="20%"><b>이메일</b></td>
			</tr>
			
			<tr align="center">
				<td><%= member.getId() %></td>
				<td><%= member.getPwd() %></td>
				<td><%= member.getName() %></td>
				<td><%= member.getEmail() %></td>
			</tr>
			
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
			</tr>
		</table>
	</body>
</html>