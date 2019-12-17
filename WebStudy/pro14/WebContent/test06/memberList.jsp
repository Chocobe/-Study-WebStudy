<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>JSTL을 이용한 회원정보 출력</title>
	</head>

	<body>
		<table align="center" border="1">
			<tr align="center" bgcolor="lightgreen">
				<td width="7%"><b>아이디</b></td>
				<td width="7%"><b>비밀번호</b></td>
				<td width="7%"><b>이름</b></td>
				<td width="7%"><b>이메일</b></td>
				<td width="7%"><b>가입일</b></td>
			</tr>
			
			<c:choose>
				<c:when test="${membersList != null}">
					<c:forEach var="mem" items="${membersList}">
						<tr align="center">
							<td>${mem.id}</td>
							<td>${mem.pwd}</td>
							<td>${mem.name}</td>
							<td>${mem.email}</td>
							<td>${mem.joinDate}</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<tr align="center">
						<td colspan="5">
							<b>등록된 회원이 없습니다.</b>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>