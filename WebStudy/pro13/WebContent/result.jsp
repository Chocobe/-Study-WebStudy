<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>로그인 결과</title>
	</head>

	<body>
		<%
			if(userID.length() == 0) {
		%>
				<jsp:forward page="login.jsp"/>
		<%
			}
		%>
		
		<h1>환영합니다 <%= userID %> 님!</h1>
	</body>
</html>