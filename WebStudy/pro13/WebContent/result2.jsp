<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%!
	String msg = "아이디를 입력하지 않았습니다. 아이디를 입력해 주세요.";
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
		<title></title>
	</head>

	<body>
		<%
			if(userID.length() == 0) {
		%>
				<jsp:forward page="login2.jsp">
					<jsp:param name="msg" value="<%= msg %>"/>
				</jsp:forward>
		<%
			}
		%>
		
		<h1>환영합니다. <%= userID %> 님!</h1>
	</body>
</html>