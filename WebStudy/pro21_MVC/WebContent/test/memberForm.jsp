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
		<form method="POST" action="${contextPath}/test/memberInfo.do">
			<h1 class="text_center">회원 가입창</h1>
			
			<table align="center">
				<tr>
					<th><p align="right">아이디</p></th>
					<td><input type="text" name="id"></td>
				</tr>
				
				<tr>
					<th><p align="right">비밀번호</p></th>
					<td><input type="password" name="pwd"></td>
				</tr>
				
				<tr>
					<th><p align="right">이름</p></th>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<th><p align="right">이메일</p></th>
					<td><input type="text" name="email"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="회원정보"></td>
				</tr>
			</table>
		</form>
	</body>
</html>