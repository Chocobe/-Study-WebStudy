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
		<form method="POST" action="${contextPath}/mem4.do?action=insertMember2">
			<h1>회원 가입창</h1>
			
			<table align="center">
				<tr>
					<th width="200">아이디</th>
					<td width="400"><input type="text" name="id"></td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</body>
</html>