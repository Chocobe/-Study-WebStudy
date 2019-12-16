<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<%-- <c:set var="name" value="홍길동" scope="page"/> --%>
<c:set var="age" value="22" scope="page"/>
<c:set var="height" value="177" scope="page"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<table border="1" align="center">
			<tr align="center" bgcolor="#99CCFF">
				<td width="7%"><b>아이디</b></td>
				<td width="7%"><b>비밀번호</b></td>
				<td width="7%"><b>이름</b></td>
				<td width="7%"><b>나이</b></td>
				<td width="7%"><b>키</b></td>
			</tr>
			
			<tr align="center">
			<c:choose>
				<c:when test="${empty name}">
					<td colspan="5">이름을 입력하세요 !</td>
				</c:when>
				
				<c:otherwise>
					<td>${id}</td>
					<td>${pwd}</td>
					<td>${name}</td>
					<td>${age}</td>
					<td>${height}</td>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>