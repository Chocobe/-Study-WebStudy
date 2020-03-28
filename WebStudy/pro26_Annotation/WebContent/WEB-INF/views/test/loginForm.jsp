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
		<form method="POST" action="${contextPath}/test/login5.do">
			<!-- <input type="hidden" name="email" value="hong@test.com"> -->
			
			<table width="400">
				<tr>
					<td>아이디 <input type="text" name="userID"></td>
				</tr>
				
				<tr>
					<td>이름 <input type="text" name="userName"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</body>
</html>