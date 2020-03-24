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
		<h1>회원목록</h1>
		
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>가입일</th>
				<th>삭제</th>
			</tr>
			
			<c:forEach var="member" items="${membersList}">
				<tr>
					<td>${member.id}</td>
					<td>${member.pwd}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.joinDate}</td>
					<td><a href="${contextPath}/mem4.do?action=deleteMember&id=${member.id}">삭제하기</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="button" value="홈으로" onclick="location.href='${contextPath}/test02/search.jsp';">
	</body>
</html>