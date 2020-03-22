<%@ page
	pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"
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
		<form method="POST" action="${contextPath}/test/login.do">
			<table border="0" width="80%" align="center">
				<tr align="center">
					<th>아이디</th>
					<th>비밀번호</th>
				</tr>
				
				<tr align="center">
					<td><input type="text" name="userID"></td>
					<td><input type="password" name="password"></td>
				</tr>
				
				<tr align="center">
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>				
			</table>
		</form>
	</body>
</html>