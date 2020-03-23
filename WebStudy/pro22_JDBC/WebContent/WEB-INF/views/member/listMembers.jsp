<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<table border="1" align="center" width="80%">
			<tr align="center" bgcolor="lightgreen">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>가입일</th>
			</tr>
			
			<c:forEach var="member" items="${membersList}">
				<tr align="center">
					<td>${member.id}</td>
					<td>${member.pwd}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.joinDate}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>