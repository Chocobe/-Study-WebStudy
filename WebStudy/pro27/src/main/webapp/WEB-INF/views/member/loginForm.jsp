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
		<title>로그인 창</title>
		
		<c:if test="${result == 'loginFailed'}">
			<script>
				window.onload = function() {
					alert("아이디나 비밀번호가 틀립니다. 다시 로그인 하세요 !");
				}
			</script>
		</c:if>
	</head>

	<body>
		<form action="${contextPath}/member/login.do" method="POST">
			<table border="1" style="border-collapse: collapse;" align="center">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
				</tr>
				
				<tr>
					<td><input type="text" name="id"></td>
					<td><input type="password" name="pwd"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
						<input type="reset" value="다시입력">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>