<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>out 내장객체 테스트2</title>
	</head>

	<body>
		<h1>스크립트릿 으로 출력</h1>
		<%
			if((name != null && name.length() != 0) && (age != null && age.length() != 0)) {
		%>
				<h1><%= name %>, <%= age %></h1>
		<%
			} else {
		%>
				<h1>이름과 나이를 입력 하세요</h1>
		<%
			}
		%>
		
		<hr/>
		
		<h1>out 내장객체로 출력</h1>
		<%
			if((name != null && name.length() != 0) && (age != null && age.length() != 0)) {
				out.print("<h1>" + name + ", " + age + "</h1>");
				
			} else {
				out.print("<h1>이름과 나이를 입력 하세요</h1>");
			}
		%>
	</body>
</html>