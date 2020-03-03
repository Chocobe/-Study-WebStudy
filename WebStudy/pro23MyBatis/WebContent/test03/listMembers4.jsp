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
		<h1>회원검색 결과</h1>
		
		<table>
			<c:forEach var="member" items="${membersList}">
				<tr align="center">
					<td>${member.id}</td>
					<td>${member.pwd}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.joinDate}</td>
					<td><a href="${pageContext.request.contextPath}/mem4.do?action=deleteMember&id=${member.id}">삭제하기</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>