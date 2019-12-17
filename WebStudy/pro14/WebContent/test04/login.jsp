<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<form method="POST" action="result.jsp">
			아이디 : <input type="text" name="userID"><br/>
			비밀번호 : <input type="password" name="userPW"><br/>
			<input type="submit" value="로그인">
			<input type="reset" value="다시입력">
		</form>
	</body>
</html>