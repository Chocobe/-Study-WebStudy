<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setAttribute("name", "이순신");
	request.setAttribute("address", "서울시 강남구");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>request 스코프 테스트1</title>
	</head>

	<body>
		<%
			RequestDispatcher dispatcher = request.getRequestDispatcher("./requestTest2.jsp");
			dispatcher.forward(request, response);
		%>
	</body>
</html>