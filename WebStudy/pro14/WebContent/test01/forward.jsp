<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("address", "서울시 강남구");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>forward</title>
	</head>

	<body>
		<jsp:forward page="member2.jsp"/>
	</body>
</html>